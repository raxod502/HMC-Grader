import sys

from app.scripts.helpers import *
from app.structures.models.user import *

if __name__ == "__main__":
  courseName = "CS 5" #raw_input("Course Name: ")
  semester = "Spring 15" #raw_input("Course Semester: ")

  course = getCourse(semester, courseName)

  if course == None:
    print "Could not find the course you specified"
    sys.exit(1)

  printType = int(raw_input('''Output should be:
0) Only usernames
1) First name Last Name
2) Last name, First name
3) Username: First name Last name
4) Username: Last name, First name
>>> ''' ))

  students = User.objects.filter(courseStudent=course)

  if printType == 0:
    for s in students:
      print s.username

  elif printType == 1:
    for s in students:
      print s.firstName + " " + s.lastName

  elif printType == 2:
    for s in students:
      print s.lastName + ", " + s.firstName

  elif printType == 3:
    for s in students:
      print s.username + ": " + s.firstName + " " + s.lastName

  elif printType == 4:
    for s in students:
      print s.username + ": " + s.lastName + ", " + s.firstName

  else:
    print "Not a valid output type"
    sys.exit(1)