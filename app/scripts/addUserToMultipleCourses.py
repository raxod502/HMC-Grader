import sys

from app.scripts.helpers import *
from app.structures.models.user import *
from app.structures.models.course import *

if __name__ == "__main__":
  # Get user
  username = raw_input("Username: ")
  user = getUser(username)

  if user == None:
    print "Could not find the user you specified"
    sys.exit(1)

  userType = int(raw_input('''Users should be added as:
0) Students
1) Graders
>>> ''' ))

  if userType < 0 or userType > 1:
    print "Not a valid user type"
    sys.exit(1)

  # Get courses and add them 
  courseNames = raw_input("Course Names: ")
  semester = raw_input("Course Semester: ")

  courseNamesArray = [x.strip() for x in courseNames.split(',')] 

  for cn in courseNamesArray:
    course = getCourse(semester, cn)
  
    if course == None:
      print "Could not find " + cn + " for the semester " + semester
      sys.exit(1)

    if userType == 0:
      print "Adding " + user.username + " as a student for " + course.name

      addCourse = query_yes_no("Do you want to add this course?")

      if addCourse:
        user.courseStudent.append(course)
        user.save()
    
    elif userType == 1:
      print "Adding " + user.username + " as a grutor for " + course.name

      addCourse = query_yes_no("Do you want to add this course?")

      if addCourse:
        user.courseGrutor.append(course)
        user.save()
