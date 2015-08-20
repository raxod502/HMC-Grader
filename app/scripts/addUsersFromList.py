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

  if userType < 0 or userType > 1:
    print "Not a valid user type"
    sys.exit(1)

  numRowsToClear = int(raw_input("Number of rows to ignore at the top of the csv: "))
  nameIndex = int(raw_input("Index of name column: "))
  emailIndex = int(raw_input("Index of email column: "))

  #Actually read the file to get the users info
  with open(sys.argv[1], 'rU') as csvFile:
    studentReader = csv.reader(csvFile, delimiter=',', quotechar='"')

    #clear rows that do not have student info
    for i in range(numRowsToClear):
      studentReader.next()
    
    #special case for the first loop to check column numbers
    firstLoop = True

    #Read info from CSV file
    for row in studentReader:
      name = row[nameIndex]
      email = row[emailIndex].strip()

      #handles empty rows
      if (name == '') or (email == ''):
        continue

      lastName, firstMidName = name.split(",")
      lastName = lastName.strip()
      firstMidName = firstMidName.strip()

      firstMidNameClean = cleanName(firstMidName)
      lastNameClean = cleanName(lastName)

      if firstLoop:
        firstLoop = False
        usernameEx = createUsername(firstMidNameClean, lastNameClean)
        print "Your settings would result in entries like:"
        print lastName + ", "+ firstMidName + " " + "(" + usernameEx + "): " + email

        continueScript = query_yes_no("Do you want to use these index numbers?")

        if not continueScript:
          print "Please rerun this script with the correct column indexes"
          sys.exit(1)

        else:
          if userType == 0:
            print "Adding users as students to " + course.name + " for " + course.semester
          if userType == 1:
            print "Adding users as grutors to " + course.name + " for " + course.semester

      u = addOrGetUser(firstMidNameClean, lastNameClean, email)
      if userType == 0:
        u.courseStudent.append(course)
      elif userType == 1:
        u.courseGrutor.append(course)
      u.save()

      print lastName + ", "+ firstMidName + " " + "(" + u.username + "): " + email
  
