import sys

from app.scripts.helpers import *
from app.structures.models.user import *
from app.structures.models.course import *
from app.structures.models.gradebook import *

if __name__ == "__main__":
  username = raw_input("Username: ")
  
  user = getUser(username)

  if user == None:
    print "Could not find the user you specified"
    sys.exit(1)


  statType = int(raw_input('''Statistics to display:
0) Assignment grades only
1) Assignment grades broken into problems
2) Comments only
3) Assignment grades and comments
4) Problem grades and comments
>>> ''' ))

  if statType not in range(0,5):
    print "Not a valid option"
    sys.exit(1)

  currentCourseList = user.courseStudent

  for course in currentCourseList:
    print course.name + " (" + course.semester + ")"

    assignmentsList = course.assignments

    for assignment in assignmentsList:
      print assignment.name

      earnedTotal = 0
      possibleTotal = 0
      comments = ""

      problemsList = assignment.problems

      for problem in problemsList:
        sub = problem.getLatestSubmission(user)
        pointsPossible = problem.totalPoints()
        possibleTotal += pointsPossible

        if sub == None:
          continue

        grade = sub.grade.totalScore()
        earnedTotal += grade
        comments += problem.name + ": " + sub.comments + "\n"

        if statType == 1 or statType == 4:
          print "%s: %d / %d" % (problem.name, grade, pointsPossible)

      if statType != 2: 
        print "TOTAL: %d / %d" % (earnedTotal, possibleTotal)

      if statType in [2,3,4]:
        print "Comments: \n" + comments
