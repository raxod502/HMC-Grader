# coding=utf-8

from app import app, celery, db
from app.structures.models.user import User
from app.structures.models.course import Problem , Course, AssignmentGroup
from app.structures.models.gradebook import GBGrade

import os,shutil, json, re
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
  pattern = "%s:(.*)" % testName

  out = ""
  for m in re.finditer(pattern, summary.setdefault('rawOut', "")):
    out += m.group(1) + "\n"
  err = ""
  for m in re.finditer(pattern, summary.setdefault('rawErr', "")):
    err += m.group(1) + "\n"
  return out, err


@celery.task()
def gradeSubmission(pid, uid, subnum):
  try:
    user = User.objects.get(id=uid)
    problem = Problem.objects.get(id=pid)
    course, assignment = problem.getParents()

    #First check if tests have even been assigned
    if len(problem.testfiles) == 0:
      #If there are none we are done
      sub = problem.getSubmission(user, subnum)
      #Set the status as awaiting grader unless it is already at a higher point
      #than that
      sub.status = max(sub.status, 2)
      sub.autoGraderComments = "No tests provided. Testing complete."
      sub.save()
      return

    #Create the directory name for the testing files
    #We use tempfile.mkdtemp to get a random secure temporary directory
    from tempfile import mkdtemp
    testDirPath = mkdtemp()

    #Change to that directory
    os.chdir(testDirPath)

    #Get all submitted files and put them in the temp directory
    submissionDir = getSubmissionPath(course, assignment, problem, user, subnum)
    testsDir = getTestPath(course, assignment, problem)
    submittedFiles = [f for f in os.listdir(submissionDir) if os.path.isfile(os.path.join(submissionDir, f))]

    #Move the files
    requiredFiles = problem.getRequiredFiles()
    # for f in submittedFiles:
    #   if f in requiredFiles:
    #     requiredFiles.remove(f)
    #   shutil.copy(os.path.join(submissionDir, f), testDirPath)

    requiredFiles = ensureFiles(requiredFiles, submissionDir)

    if len(requiredFiles) > 0:
      sub = problem.getSubmission(user, subnum)
      sub.status = max(sub.status, 2)
      sub.autoGraderComments = "Submission missing files."
      sub.save()
      shutil.rmtree(testDirPath)
      return

    for f in os.listdir(submissionDir):
      shutil.copy(os.path.join(submissionDir, f), testDirPath)

    #Move the test files
    #NOTE: We move these files second so that if a student submits a file that
    #has the same name as one of the test files it will get overwritten. This
    #is to try to prevent test spoofing where a student could submit a test file
    #in which all tests trvially pass. (Not that that should happen with Mudders
    #but we want to be secure none the less)
    for f in os.listdir(testsDir):
      shutil.copy(os.path.join(testsDir,f), testDirPath)


    #Get the submission so we can print results
    sub = problem.getSubmission(user, subnum)

    sub.status = max(sub.status, 1)
    sub.save()

    sub.autoGraderComments = ""

    #Run each test function and parse the results
    for f in problem.testfiles:
      #TODO: change user to prevent bad things
      with open(f+".json") as spec:
        gradeSpec = json.load(spec)

      #Start a section for this file
      sub.autoGraderComments += "### **Test file**: " + f + " ###\n"

      try:
        testRunner = getTestRunners()[gradeSpec['type']]

        summary, failedTests = testRunner([], f, 30)

        if summary['timeout']:
          sub.autoGraderComments += "<font color='Red'>A timeout occured</font>\n\n"
          continue

        if summary['died']:
          sub.autoGraderComments += "<font color='Red'>An error occured and the testing file failed to execute.</font>\n\n"
          sub.autoGraderComments += "<pre>" + summary['generalError'] + "</pre>\n"
          continue

        sub.autoGraderComments += "**" + str(summary['totalTests']) + " tests run**\n\n"
        sub.autoGraderComments += "**" + str(summary['failedTests']) + " tests failed**\n\n"

        #Go through the sections and find assign points
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
      except Exception as e:
        sub.autoGraderComments += "<font color='Red'>Error running tests:</font> \n<pre>" + str(e) + "</pre>\n\n"

    #Remove the testing directory and all of the files
    shutil.rmtree(testDirPath)

    sub = problem.getSubmission(user, subnum)
    if problem.autoGradeOnly:
      sub.status = 4
    else:
      sub.status = max(sub.status, 2)
    sub.save()

  except (User.DoesNotExist, Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    pass
