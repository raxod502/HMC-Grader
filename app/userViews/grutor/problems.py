# -*- coding: utf-8 -*-
'''
This module supports all of the view and callback functions that can be used by
grutors and instructors performing a grutor role.
'''

#import the app and the login manager
from app import app, loginManager

from flask import g, request, render_template, redirect, url_for, flash, send_file, jsonify, abort
from flask.ext.login import login_user, logout_user, current_user, login_required

from flask.ext.mongoengine import DoesNotExist

from werkzeug import secure_filename

from app.structures.models.user import *
from app.structures.models.gradebook import *
from app.structures.models.course import *

from app.structures.forms import SubmitAssignmentForm

import os, datetime, fcntl, random
import markdown

from app.helpers.filestorage import *

@app.route('/grutor/gradelist/problem/<pid>')
@login_required
def grutorGradelistProblem(pid):
  '''
  Function Type: View Function
  Template: grutor/problems.html
  Purpose: Display all of the student submissions for the problem specified by
  <pid>.

  Inputs:
    pid: A problem object ID

  Template Parameters:
    course: The course which contains the problem specified by <pid>
    assignment: The assignment group containing the problem specified by <pid>
    problem: The problem specified by <pid>
    users: A list of the students who are enrolled in <course>

  Forms handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      abort(403)

    #Get the students for this course
    students = User.objects.filter(courseStudent=c)

    return render_template("grutor/problems.html", \
                            course=c, problem=p, assignment=a, users=students)
  except Course.DoesNotExist as e:
    abort(404)

#
# Redirects
# Here are the needed redirect functions. These are used to go from this page to
# another page while performing an action

@app.route('/grutor/grade/<pid>/random')
@login_required
def grutorGradeRandom(pid):
  '''
  Function Type: Callback-Redirect Function
  Purpose: Select an ungraded student submission and claim it for the current
  grader. If it selects a student without a submission one is created.

  Inputs:
    pid: The object ID of the problem that is being graded

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    #For security we redirect anyone who shouldn't be here to the index
    if not (c in current_user.gradingCourses()):
      abort(403)

    #Shuffle the users in the course so we can get a random one
    courseUsers = list(User.objects.filter(courseStudent=c))
    random.shuffle(courseUsers)

    #For each user try to get a submission for them
    for key in p.studentSubmissions.keys():
      username = userFromKey(key)
      user = User.objects.get(username=username)

      #Get the pymongo collection for some atomic actions not provided by
      #the mongoengine wrapper
      subCol = Submission._get_collection()
      sub = p.getLatestSubmission(user)

      if sub == None:
        flash("Bad state for user %s. Please notify the administrator."%(username), "error")
        continue

      if sub.partner == None:
        res = subCol.find_and_modify(query={'_id': sub.id, 'status':SUBMISSION_TESTED, 'isLatest':True}, \
          update={'$set': {'status':SUBMISSION_GRADING, 'gradedBy': g.user.id}})
      else:
        otherSub = sub.partnerSubmission
        #We use total lock oerdering to prevent deadlock
        subList = sorted([sub, otherSub], key=lambda x: x.id)
        res = subCol.find_and_modify(query={'_id': subList[0].id, 'status':SUBMISSION_TESTED, 'isLatest':True}, \
          update={'$set': {'status':SUBMISSION_GRADING, 'gradedBy': g.user.id}})
        #res = Submission.objects.exec_js(LOCK_QUERY, id=subList[0].id, uid=g.user.id)
        if res == None:
          continue
        res = subCol.find_and_modify(query={'_id': subList[1].id, 'status':SUBMISSION_TESTED, 'isLatest':True}, \
          update={'$set': {'status':SUBMISSION_GRADING, 'gradedBy': g.user.id}})
        #res = Submission.objects.exec_js(LOCK_QUERY, id=subList[1].id, uid=g.user.id)

      if not res == None:
        return redirect(url_for("grutorGradeSubmission", pid=pid, uid=user.id, subnum=p.getSubmissionNumber(user)))
    flash("All submissions have been claimed", "warning")
    flash("Untested submissions or submissions that crashed the auto-grader are not considered by this button. Please look below for such submissions.")
    return redirect(url_for('grutorGradelistProblem', pid=pid))

  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)
  except User.DoesNotExist:
    #If the user doesn't exist we have a problem
    flash("""Successfully locked a submission but the user for that
    submission couldn't be found in the database. Please contact a system
    administrator to have them resolve this issue.""", "error")
    abort(404)

@app.route('/grutor/create/<pid>/<uid>')
@login_required
def grutorMakeBlank(pid, uid):
  '''
  Function Type: Callback-Redirect Function
  Purpose: When a student does not have a submission for a given assignment this
  function is called. It creates a blank submission with no files and then
  redirects the grader to the grade submission page.

  Inputs:
    pid: The object ID for the problem that is being graded.
    uid: The object ID of the user who is being graded.

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    user = User.objects.get(id=uid)

    #For security purposes we send anyone who isnt in this class to the index
    if not (c in current_user.gradingCourses()):
      abort(403)

    #Check that the user we are trying to create a submission for is in the class
    if not (c in user.courseStudent):
      flash("The user you were trying to make a submission for is not in the course.")
      abort(404)

    #Create a blank submission
    #Create the grade
    grade = GBGrade()
    grade.save()
    p.gradeColumn.scores[user.keyOfUsername()] = grade


    p.studentSubmissions[user.keyOfUsername()] = StudentSubmissionList()

    #create a filepath
    filepath = getSubmissionPath(c, a, p, user, 1)

    sub = Submission()
    sub.problem = p
    #Initial fields for submission
    sub.filePath = filepath
    sub.grade = p.gradeColumn.scores[user.keyOfUsername()]
    sub.submissionTime = datetime.datetime.utcnow()
    sub.status = SUBMISSION_GRADING
    sub.gradedBy = User.objects.get(id=g.user.id)

    sub.save()
    p.studentSubmissions[user.keyOfUsername()].addSubmission(sub)

    #The grader is making this so it isn't late
    sub.isLate = False

    #Create the needed folders
    os.makedirs(filepath)

    p.save(cascade=True)
    return redirect(url_for('grutorGradeSubmission', uid=uid, pid=pid, subnum=1))
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)
