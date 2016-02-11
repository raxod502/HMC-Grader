# coding=utf-8

from app.plugins.latework import getLateCalculators

def getStudentAssignmentScores(course, user):
  '''Generates a gradelist and runs it through the late calculator'''
  # Create a gradelist
  gl = []
  for a in course.assignments:
    al = []
    for p in sorted(a.problems, key=lambda x: x.name):
      sub = p.getLatestSubmission(user)
      if not sub == None:
        gradeData = {}
        gradeData['rawTotalScore'] = sub.grade.totalScore()
        gradeData['timeDelta'] = p.duedate - sub.submissionTime
        gradeData['isLate'] = sub.isLate
        gradeData['maxScore'] = p.totalPoints()
        al.append(gradeData)
      else:
        al.append(None)
    gl.append(al)

  lateCalculator = getLateCalculators()[course.lateGradePolicy]

  gl = lateCalculator(gl)
  return gl

def getStudentAuxScores(course, user):
  scores = []
  for group in course.gradeBook.auxillaryGrades:
    for col in group.columns:
      scores.append({'score':col.scores[user.keyOfUsername()].totalScore(), 'maxScore':col.maxScore})
  return scores

def getStudentScoresNoCalculator(course, user):
  '''Generates a gradelist without running it through the calculator'''
  # Create a gradelist
  gl = []
  for a in course.assignments:
    al = []
    for p in sorted(a.problems, key=lambda x: x.name):
      sub = p.getLatestSubmission(user)
      if not sub == None:
        gradeData = {}
        gradeData['rawTotalScore'] = sub.grade.totalScore()
        gradeData['timeDelta'] = p.duedate - sub.submissionTime
        gradeData['isLate'] = sub.isLate
        gradeData['maxScore'] = p.totalPoints()
        al.append(gradeData)
      else:
        al.append(None)
    gl.append(al)

  return gl

def getNumberOfEurosUsed(course, user):
  '''Generates a count of the euros used by a user'''
  eurosUsed = 0
  for a in course.assignments:
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

def getLateProblems(course, user):
  '''Generates a gradelist of the late problems for a user'''
  gl = []
  for a in course.assignments:
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

def getEuroCountAndLateProblemsList(course, user):
  '''Generates a count of euros used and a gradelist of the late problems for a user'''
  gl = []
  eurosUsed = 0
  for a in course.assignments:
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