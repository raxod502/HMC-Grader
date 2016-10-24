# coding=utf-8

from app import db
from werkzeug.security import generate_password_hash, check_password_hash
from mongoengine import NULLIFY, PULL

from app.helpers.filestorage import *

from app.structures.models.user import User

#Some constants for doing submission status stuff
SUBMISSION_BADSTATE = -1
SUBMISSION_UNGRADED = 0
SUBMISSION_TESTING = 1
SUBMISSION_TESTED = 2
SUBMISSION_GRADING = 3
SUBMISSION_GRADED = 4

class Submission(db.Document):
  '''
  A submission contains all the information about one attempt at a given problem
  by a student.
  '''
  #bookkeeping
  submitter = db.ReferenceField('User')
  problem = db.ReferenceField('Problem')
  isLatest = db.BooleanField(default=True)

  submissionTime = db.DateTimeField(required=True)
  isLate = db.BooleanField(default=False)
  grade = db.ReferenceField('GBGrade')
  status = db.IntField(default=0)
  gradedBy = db.ReferenceField('User')

  #Comment fields
  comments = db.StringField(default="")
  autoGraderComments = db.StringField(default="")

  #partnerinfo
  partner = db.ReferenceField('User')
  partnerSubmission = db.ReferenceField('Submission')

  meta = {"cascade": True}

  def cleanup(self):
    try:
      if self.partnerInfo:
        self.partnerInfo.delete()
      self.grade.delete()
    except:
      pass

  def getStatus(self):
    if self.status == SUBMISSION_BADSTATE:
      return "danger", "Bad State"
    elif self.status == SUBMISSION_UNGRADED:
      return "info", "Submitted (Waiting for Auto-grader)"
    elif self.status == SUBMISSION_TESTING:
      return "warning", "Autograde in progress"
    elif self.status == SUBMISSION_TESTED:
      return "info", "Submitted (Auto-graded, Waiting for Grader)"
    elif self.status == SUBMISSION_GRADING:
      return "warning", "Grading in progress"
    elif self.status == SUBMISSION_GRADED:
      return "success", "Graded"
    else:
      return "warning", "Unknown"

  def setGrades(self, gradeDict, zeroOthers=False):
    for k in gradeDict.iterkeys():
      if not k in problem.rubric:
        raise Exception("Requested rubric section " + k + " is not in the problem rubric")

    #If we validated all the keys then apply the grades
    #iterate across the rubric so that we can zero non-supplied grades if needed
    for k in problem.rubric.iterkeys():
      if not k in gradeDict and zeroOthers:
        self.grade[k] = 0.0
      else:
        self.grade[k] = gradeDict[k]

    #save the grade when we are done
    self.grade.save()

  def setGradedBy(self, grader):
    if type(grader) is str:
      grader = User.objects.get(username=grader)

    if type(grader) is User:
      self.gradedBy = grader
    else:
      raise Exception("Invalid type for gradedBy field")

class StudentSubmissionList(db.EmbeddedDocument):
  '''
  A list of all the submissions a student has made for a specific problem.
  '''
  submissions = db.ListField(db.ReferenceField('Submission'))

  meta = {"cascade": True}

  def cleanup(self):
    for s in self.submissions:
      s.cleanup()
      s.delete()
    self.submissions = []

  def addSubmission(self, sub):
    if len(self.submissions) > 0:
      self.submissions[-1].isLatest = False
      self.submissions[-1].save()
    self.submissions.append(sub)

class Problem(db.Document):
  '''
  One problem that a student can submit files to.
  '''
  name = db.StringField()
  gradeColumn = db.ReferenceField('GBColumn', reverse_delete_rule=NULLIFY)
  duedate = db.DateTimeField()

  #The problem rubric
  rubric = db.MapField(db.DecimalField())

  #List of the names of the files we test with
  testfiles = db.ListField(db.StringField())

  #Can students have partners
  allowPartners = db.BooleanField(default=True)

  #Which files must a student submit
  requiredFiles = db.StringField(default=None)
  strictFiles = db.StringField(default=None)
  bannedFiles = db.StringField(default=None)

  #URLs for grader notes and for problem specification
  gradeNotes = db.StringField()
  problemPage = db.StringField()

  #Settings for releasing grades
  releaseAutoComments = db.BooleanField(default=True)
  autoGradeOnly = db.BooleanField(default=False)

  #Settings for opening and closing a problem
  isOpen = db.BooleanField(default=True)


  #Map usernames to submission lists
  studentSubmissions = db.MapField(db.EmbeddedDocumentField('StudentSubmissionList'))

  meta = {"cascade": True}

  def __init__(self, name, **data):
    super(Problem, self).__init__(**data)
    self.name = name

  def getStatusCount(self):
    c,a = self.getParents()
    users = User.objects.filter(courseStudent=c)
    ungraded = 0
    ip = 0
    done = 0
    for u in users:
      sub = self.getLatestSubmission(u)
      if sub == None:
        continue
      if sub.status < 3:
        ungraded += 1
      elif sub.status == 3:
        ip += 1
      else:
        done += 1
    return ungraded, ip, done

  def cleanup(self):
    if self.gradeColumn != None:
      self.gradeColumn.cleanup()
      self.gradeColumn.delete()
    for k in self.studentSubmissions:
      self.studentSubmissions[k].cleanup()

  def totalPoints(self):
    total = 0
    for k in self.rubric:
      total += self.rubric[k]
    return total

  def getSubmissionNumber(self, user):
    '''gets the number of the latest submission'''
    if user.keyOfUsername() in self.studentSubmissions:
      return len(self.studentSubmissions[user.keyOfUsername()].submissions)
    else:
      return 0

  def getSubmission(self, user, subnum):
    '''Returns a single submission'''
    return self.studentSubmissions[user.keyOfUsername()].submissions[int(subnum)-1]

  def getLatestSubmission(self, user):
    '''Gets the latest submission for a user'''
    if self.getSubmissionNumber(user) == 0:
      return None
    else:
      latestSubmission = self.getSubmission(user, self.getSubmissionNumber(user))
      if isinstance(latestSubmission, Submission):
        return latestSubmission
      else:
        return None

  def getParents(self):
    a = AssignmentGroup.objects.get(problems=self)
    c = Course.objects.get(assignments=a)
    return c,a

  def getFiles(self, user, subnum):
    from os import listdir
    from os.path import isfile, join
    c, a = self.getParents()
    filePath = getSubmissionPath(c, a, self, user, subnum)
    return [ f for f in listdir(filePath) if isfile(join(filePath,f)) ]

  def getFilePath(self, user, subnum):
    c, a = self.getParents()
    return getSubmissionPath(c, a, self, user, subnum)

  def getTestFilePath(self):
    c, a = self.getParents()
    ensurePathExists(getTestPath(c, a, self))
    return getTestPath(c, a, self)

  def getRequiredFiles(self):
    import re
    if self.requiredFiles != None and len(self.requiredFiles) > 0:
      return re.split(' *, *', self.requiredFiles)
    else:
      return []

  def getStrictFiles(self):
    import re
    if self.strictFiles != None and len(self.strictFiles) > 0:
      return re.split(' *, *', self.strictFiles)
    else:
      return []

  def getSubmissionInfo(self, sub):
    I = self.studentSubmissions.iteritems()
    for key, value in self.studentSubmissions.iteritems():
      if sub in value.submissions:
        return User.objects.get(username=key.replace("&dot;",".")), (value.submissions.index(sub)+1)
    return None, -1


class AssignmentGroup(db.Document):
  '''
  A logical grouping of problems (e.g. One week's homework)
  '''
  name = db.StringField(required=True)
  gradeEntry = db.ReferenceField('GBGroup', reverse_delete_rule=NULLIFY)
  problems = db.ListField(db.ReferenceField('Problem', reverse_delete_rule=PULL))

  meta = {"cascade": True}

  def __init__(self, name, **data):
    super(AssignmentGroup, self).__init__(**data)
    self.name = name

  def cleanup(self):
    if self.gradeEntry != None:
      self.gradeEntry.cleanup()
    for p in self.problems:
      p.cleanup()
      p.delete()

class Course(db.Document):
  '''
  One sememsters class
  '''
  #Identification information
  name = db.StringField(required=True)
  semester = db.StringField(required=True)

  #Information for grading and submission
  gradeBook = db.EmbeddedDocumentField('GradeBook')
  assignments = db.ListField(db.ReferenceField('AssignmentGroup', reverse_delete_rule=PULL))

  #Is this course still being taught at this time
  isActive = db.BooleanField(default=True)

  #Do we hide the student's username during grading
  anonymousGrading = db.BooleanField(default=False)
  #Do we hide who graded an assignment from the student
  anonymousGrutors = db.BooleanField(default=False)
  #Map real usernames to identifiers
  anonIds = db.MapField(db.StringField())
  #How do we calculate late grades (Defaults to one that just highlights late grades)
  lateGradePolicy = db.StringField(default="Highlighter")

  homepage = db.StringField(default="#")

  meta = {"cascade": True, 'ordering': ["+semester", "+name"]}

  def cleanup(self):
    self.gradeBook.cleanup()

    for a in self.assignments:
      a.cleanup()
      a.delete()

  def ensureIDs(self):
    users = User.objects.filter(courseStudent=self)
    for u in users:
      if u.keyOfUsername() in self.anonIds:
        continue
      else:
        from random import choice, randint
        from string import ascii_lowercase
        while True:
          ID = choice(ascii_lowercase) + choice(ascii_lowercase)+ str(randint(0,9))
          if not ID in self.anonIds.values():
            self.anonIds[u.keyOfUsername()] = ID
            break
    self.save()

  def getIdentifier(self, username):
    if not username in self.anonIds:
      self.ensureIDs()
    return self.anonIds[username]

  def getNumberOfEurosUsed(self, user):
    '''Generates a count of the euros used by a user'''
    eurosUsed = 0
    for a in self.assignments:
      assignmentContainsLateProblems = False
      for p in sorted(a.problems, key=lambda x: x.name):
        sub = p.getLatestSubmission(user)
        if not sub == None:
          if sub.isLate:
            assignmentContainsLateProblems = True
      #After looping through all the problems for the assignment, check if a euro was used
      if assignmentContainsLateProblems:
        eurosUsed += 1
      
    return eurosUsed

  def getLateProblems(self, user):
    '''Generates a gradelist of the late problems for a user'''
    gl = []
    for a in self.assignments:
      al = []
      for p in sorted(a.problems, key=lambda x: x.name):
        sub = p.getLatestSubmission(user)
        if not sub == None:
          if sub.isLate:
            gradeData = {}
            gradeData['rawTotalScore'] = sub.grade.totalScore()
            gradeData['timeDelta'] = p.duedate - sub.submissionTime
            gradeData['isLate'] = sub.isLate
            gradeData['maxScore'] = p.totalPoints()
            al.append(gradeData)
      gl.append(al)

    return gl

  def getLateAssignments(self, user):
    '''Generates a list of the late assignments for a user'''
    assignmentList = []
    for a in self.assignments:
      assignmentContainsLateProblems = False
      for p in sorted(a.problems, key=lambda x: x.name):
        sub = p.getLatestSubmission(user)
        if not sub == None:
          if sub.isLate:
            assignmentContainsLateProblems = True
      if assignmentContainsLateProblems:
        assignmentList.append(a)

    return assignmentList

  def getEuroCountAndLateProblemsList(self, user):
    '''Generates a count of euros used and a gradelist of the late problems for a user'''
    gl = []
    eurosUsed = 0
    for a in self.assignments:
      al = []
      assignmentContainsLateProblems = False
      for p in sorted(a.problems, key=lambda x: x.name):
        sub = p.getLatestSubmission(user)
        if not sub == None:
          if sub.isLate:
            assignmentContainsLateProblems = True
            gradeData = {}
            gradeData['rawTotalScore'] = sub.grade.totalScore()
            gradeData['timeDelta'] = p.duedate - sub.submissionTime
            gradeData['isLate'] = sub.isLate
            gradeData['maxScore'] = p.totalPoints()
            al.append(gradeData)
      #Append the data about late problems to the list
      gl.append(al)

      #After looping through all the problems for the assignment, check if a euro was used
      if assignmentContainsLateProblems:
        eurosUsed += 1

    return eurosUsed, gl


  def getEuroCountAndLateAssignmentsList(self, user):
    '''Generates a count of euros used and a list of the late assignments for a user'''
    eurosUsed = 0
    assignmentList = []
    for a in self.assignments:
      assignmentContainsLateProblems = False
      for p in sorted(a.problems, key=lambda x: x.name):
        sub = p.getLatestSubmission(user)
        if not sub == None:
          if sub.isLate:
            assignmentContainsLateProblems = True
      if assignmentContainsLateProblems:
        eurosUsed += 1
        assignmentList.append(a)

    return eurosUsed, assignmentList