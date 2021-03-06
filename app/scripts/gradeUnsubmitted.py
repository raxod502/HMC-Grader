import sys

from app.scripts.helpers import *
from app.helpers.autograder import *

from app.structures.models.user import *
from app.userViews.student.submitFiles import createSubmission

from datetime import datetime

if __name__ == "__main__":
  courseName = raw_input("Course Name: ")
  semester = raw_input("Course Semester: ")

  course = getCourse(semester, courseName)

  if course == None:
    print "Could not find the course you specified"
    sys.exit(1)

  for i, a in enumerate(course.assignments):
    print "%d) %s" % (i, a.name)

  index = int(raw_input("Pick an assignment: "))

  assignment = course.assignments[index]

  for i, p in enumerate(assignment.problems):
    print "%d) %s" % (i, p.name)

  index = int(raw_input("Pick a problem: "))

  problem = assignment.problems[index]

  gradeUnsubmitted = query_yes_no("Do you want to grade unsubmitted problems?")

  if gradeUnsubmitted:
    ##### REPLACE THESE LINES TO CUSTOMIZE DIRECTLY #####
    # Ex: "Looks like you forgot this part =("
    comments = raw_input("Set the comments: ")
    score = int(raw_input("Set the score: ")) 
    #####################################################

  students = User.objects.filter(courseStudent=course)

  for s in students:
    sub = problem.getLatestSubmission(s)
    if sub == None:
      print s.username
      
      if gradeUnsubmitted:
        sub, _ = createSubmission(problem, s)
        sub.isLate = False
        sub.save()
        problem.save()

        sub.grade.scores[problem.name] = score
        sub.grade.save()
        sub.comments = comments
        sub.status = SUBMISSION_GRADED
        sub.save()
