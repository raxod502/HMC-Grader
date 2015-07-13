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

  # Get courses and add them 
  courseNames = raw_input("Course Names: ")
  semester = raw_input("Course Semester: ")

  courseNamesArray = [x.strip() for x in courseNames.split(',')] 

  for cn in courseNamesArray:
    course = getCourse(semester, cn)
  
    if course == None:
      print "Could not find " + course.name + " for the semester " + semester
      sys.exit(1)

    print "Adding " + user.username + " as a student for " + course.name

    addCourse = query_yes_no("Do you want to add this course?")

    if addCourse:
      user.courseStudent.append(course)
      user.save()
