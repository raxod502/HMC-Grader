# coding=utf-8

from app import app, celery, db
from app.structures.models.user import User
from app.structures.models.course import *
from app.structures.models.gradebook import GBGrade

import os,shutil, json, re, stat
from decimal import *
from subprocess import Popen, PIPE
from datetime import datetime

from app.plugins.autograder import getTestRunners

from app.helpers.filestorage import *

AUTOGRADER_HEADER = \
"""
# Autograder #

"""

def ensureFiles(reqFiles, filePath):
  for root, dirs, files in os.walk(filePath):
    for f in files:
      if f in reqFiles:
        reqFiles.remove(f)
  return reqFiles

def getTestPrints(summary, testName):
  pattern = "^%s:(.*)" % testName

  out = ""
  for m in re.finditer(pattern, summary.setdefault('rawOut', ""), re.M):
    out += m.group(1) + "\n"
  err = ""
  for m in re.finditer(pattern, summary.setdefault('rawErr', ""), re.M):
    err += m.group(1) + "\n"
  return out, err

def makeTestInfo(problem, user, subnum, msg=None):
  c, a = problem.getParents()
  infoString = """username: %s
  subnum: %d
  courseName: %s
  assignmentName: %s
  problemName: %s""" % (user.username, subnum, c.name, a.name, problem.name)

  if msg == None:
    print "\n" + infoString
    with open(".info", "w") as f:
      f.write(infoString)
  else:
    print "\n" + infoString + "\nMessage: " + msg

def rawTestOutput(testOutputDir, summary, testFile):
  with open(os.path.join(testOutputDir, testFile+'.out'), 'w') as out:
    out.write(summary.setdefault('rawOut', ""))
  with open(os.path.join(testOutputDir, testFile+'.err'), 'w') as out:
    out.write(summary.setdefault('rawErr', ""))


@celery.task()
def regradeSubmission(submission):
  submission.autoGraderComments = ""
  submission.grade.scores = {}
  submission.status = SUBMISSION_UNGRADED
  submission.save()
  x = submission.problem.getSubmissionInfo(submission)
  print "submission.problem.getSubmissionInfo(submission) is ", x
  print "submission.problem.getSubmissionInfo(submission)[1] is ", x[1]
  gradeSubmission(submission.problem.id, submission.submitter.id, x[1])

@celery.task()
def gradeSubmission(pid, uid, subnum):
  try:
    sub = None
    user = User.objects.get(id=uid)
    problem = Problem.objects.get(id=pid)
    course, assignment = problem.getParents()


    #First check if tests have even been assigned
    if len(problem.testfiles) == 0:
      #If there are none we are done
      sub = problem.getSubmission(user, subnum)
      #Set the status as awaiting grader unless it is already at a higher point
      #than that
      sub.status = max(sub.status, SUBMISSION_TESTED)
      sub.autoGraderComments = "No tests provided. Testing complete."
      sub.save()
      return

    #Create the directory name for the testing files
    #We use tempfile.mkdtemp to get a random secure temporary directory
    from tempfile import mkdtemp
    testDirPath = mkdtemp()

    #Change to that directory
    os.chdir(testDirPath)
    makeTestInfo(problem, user, subnum)

    #Get all submitted files and put them in the temp directory
    submissionDir = getSubmissionPath(course, assignment, problem, user, subnum)
    testOutputDir = os.path.join(submissionDir, 'rawTestOutput')
    testsDir = getTestPath(course, assignment, problem)
    submittedFiles = [f for f in os.listdir(submissionDir) if os.path.isfile(os.path.join(submissionDir, f))]

    #Move the files
    requiredFiles = problem.getRequiredFiles()

    requiredFiles = ensureFiles(requiredFiles, submissionDir)

    if len(requiredFiles) > 0:
      sub = problem.getSubmission(user, subnum)
      sub.status = max(sub.status, SUBMISSION_TESTED)
      sub.autoGraderComments = "Submission missing files."
      sub.save()
      shutil.rmtree(testDirPath)
      return

    for f in os.listdir(submissionDir):
      if os.path.isfile(os.path.join(submissionDir, f)):
        shutil.copy(os.path.join(submissionDir, f), testDirPath)
      else:
        shutil.copytree(os.path.join(submissionDir, f), os.path.join(testDirPath, f))

    #Move the test files
    #NOTE: We move these files second so that if a student submits a file that
    #has the same name as one of the test files it will get overwritten. This
    #is to try to prevent test spoofing where a student could submit a test file
    #in which all tests trvially pass. (Not that that should happen with Mudders
    #but we want to be secure none the less)
    for f in os.listdir(testsDir):
      shutil.copy(os.path.join(testsDir,f), testDirPath)

    #TODO: Fix permissions so that the grader user can read files
    #Edit permissions so the grader user can read the files
    if app.config['GRADER_USER'] != None:
      for root, dirs, files in os.walk('.'):
        for f in files:
          os.chmod(os.path.join(root, f), stat.S_IRWXO | stat.S_IRWXU| stat.S_IRWXG)


    #Get the submission so we can print results
    sub = problem.getSubmission(user, subnum)

    sub.status = max(sub.status, SUBMISSION_TESTING)
    sub.save()

    sub.autoGraderComments = ""

    try:
      shutil.rmtree(testOutputDir)
    except:
      pass
    finally:
      os.makedirs(testOutputDir)

    #Run each test function and parse the results
    for f in problem.testfiles:

      #TODO: Fix this so that it actually works
      if app.config['GRADER_USER'] == None:
        prefix = []
      else:
        prefix = ['sudo', '-u', app.config['GRADER_USER']]

      with open(f+".json") as spec:
        gradeSpec = json.load(spec)

      #If this test file has no tests we won't bother running it
      if len(gradeSpec['tests']) == 0:
        continue

      #Start a section for this file
      sub.autoGraderComments += "### **Test file**: " + f + " ###\n"

      try:
        testRunner = getTestRunners()[gradeSpec['type']]

        #Run the test
        summary, failedTests = testRunner(prefix, f, gradeSpec.setdefault('timeout', 30))

        #Put the raw test output in the test output directory
        rawTestOutput(testOutputDir, summary, f)

        if summary['timeout']:
          sub.autoGraderComments += "<font color='Red'>A timeout occurred</font>\n\n"
          continue

        if summary['died']:
          sub.autoGraderComments += "<font color='Red'>An error occurred and the testing file failed to execute.</font>\n\n"
          sub.autoGraderComments += "Stdout:\n<pre>" + summary.setdefault("rawOut","") + "</pre>\n"
          sub.autoGraderComments += "Stderr:\n<pre>" + summary.setdefault("rawErr","") + "</pre>\n"
          continue

        sub.autoGraderComments += "**" + str(summary['totalTests']) + " tests run**\n\n"
        sub.autoGraderComments += "**" + str(summary['failedTests']) + " tests failed**\n\n"

        #Go through the sections and find assign points
        if len(gradeSpec['sections']) > 0:
          for section in gradeSpec['sections']:
            sectionContent = ""
            failed = 0
            for test in section['tests']:
              testOut, testErr = getTestPrints(summary, test)
              if test in failedTests:
                failed += 1
                sectionContent += '##### <font color="Red">Failed</font>:' + test +" #####\n"
                sectionContent += '<pre>' + failedTests[test]['hint'] + '</pre>\n'
              else:
                sectionContent += '##### <font color="Green">Passed</font>:' + test +" #####\n"

              if len(testOut) != 0:
                sectionContent += 'Test output (stdout):\n<pre>' + testOut + "</pre>\n"
              if len(testErr) != 0:
                sectionContent += 'Test output (stderr):\n<pre>' + testErr + "</pre>\n"

            sectionContent += "***\n"

            #Assign the score
            assignedPoints = Decimal(section['points']) * (Decimal(1)-(Decimal(failed)/Decimal(len(section['tests']))))

            assignedString = "%.2f" % float(assignedPoints)
            pointsString = "%.2f" % float(section['points'])

            sub.autoGraderComments += "#### **Test Section**: " + section['name'] +" (" + assignedString + "/" + pointsString + ") ####\n"
            sub.autoGraderComments += sectionContent

            if section['rubric'] in sub.grade.scores:
              sub.grade.scores[section['rubric']] += assignedPoints
            else:
              sub.grade.scores[section['rubric']] = assignedPoints
        else:
          sectionContent = ""
          passed = 0
          for test in gradeSpec['tests']:
            testOut, testErr = getTestPrints(summary, test)
            if test in failedTests:
              sectionContent += '##### <font color="Red">Failed</font>:' + test +" #####\n"
              sectionContent += '<pre>' + failedTests[test]['hint'] + '</pre>\n'
            else:
              passed += 1
              sectionContent += '##### <font color="Green">Passed</font>:' + test +" #####\n"

            if len(testOut) != 0:
              sectionContent += 'Test output (stdout):\n<pre>' + testOut + "</pre>\n"
            if len(testErr) != 0:
              sectionContent += 'Test output (stderr):\n<pre>' + testErr + "</pre>\n"

          sub.autoGraderComments += "#### **Test Section**: Default (%.2f/%.2f) ###\n" %(float(passed), float(len(gradeSpec['tests'])))
          sub.autoGraderComments += sectionContent

          if "Autograder" in sub.grade.scores:
            sub.grade.scores["Autograder"] += passed
          else:
            sub.grade.scores["Autograder"] = passed


      except Exception as e:
        import traceback
        tb = traceback.format_exc()
        sub.autoGraderComments += "<font color='Red'>Error running tests:</font> \n<pre>" + str(e) + "</pre>\n\n"
        sub.autoGraderComments += "<pre>" + str(tb) + "</pre>\n\n"

    #Remove the testing directory and all of the files
    shutil.rmtree(testDirPath)

    sub = problem.getSubmission(user, subnum)
    if problem.autoGradeOnly:
      sub.status = SUBMISSION_GRADED
    else:
      sub.status = max(sub.status, SUBMISSION_TESTED)
    sub.save()

    makeTestInfo(problem, user, subnum, msg="Testing finished")

  except (User.DoesNotExist, Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    pass
  except Exception as e:
    if not sub == None:
      #If we have a submission object
      import traceback
      tb = traceback.format_exc()
      sub.autoGraderComments = "<pre>" + str(e) + "</pre>"
      sub.autoGraderComments += "<pre>" + str(tb) + "</pre>"
      sub.status = SUBMISSION_BADSTATE
      sub.save()
      print "Error Reported"
