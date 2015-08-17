import csv, sys, os, re
from itertools import izip

# print os.path.dirname(os.path.realpath(__file__))

from app.scripts.helpers import *

def cleanName(name):
  regex = re.compile('[^a-zA-Z]')
  retName = regex.sub('', name)
  return retName

if __name__ == "__main__":
  semester = raw_input("Course Semester: ")
  courseName = raw_input("Course Name: ")

  course = getCourse(semester, courseName)

  if course == None:
    print "Could not find the course you specified"
    sys.exit(1)

  userType = raw_input('''
Users should be added as:
0) Students
1) Graders

>>> ''')

  userType = int(userType)

  if userType < 0 and userType > 1:
    print "Not a valid user type"
    sys.exit(1)

  try:
    #Actually read the file to get the users info
    with open(sys.argv[1], 'r') as csvFile:
      studentReader = csv.reader(csvFile, delimiter=',', quotechar='"')

      #Read info from CSV file
      for row in studentReader:
        lastName = row[0]
        firstName = row[1]
        email = row[2].strip()

        firstNameClean = cleanName(firstName)
        lastNameClean = cleanName(lastName)

        u = addOrGetUser(firstNameClean, lastNameClean, email)
        if userType == 0:
          u.courseStudent.append(course)
        elif userType == 1:
          u.courseGrutor.append(course)
        u.save()

        print lastName + ", "+ firstName + " " + "(" + u.username + ")"
  except:
    print "Please provide a csv file"
    print "Usage is:\n <virtual-env>/bin/python " + sys.argv[0]+ " <path-to-csv-file>"
