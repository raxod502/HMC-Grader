# coding=utf-8

from app import app

from flask import g, request, render_template, redirect, url_for, flash, send_file, abort
from flask import jsonify
from flask.ext.login import login_user, logout_user, current_user, login_required

from app.structures.models.user import *
from app.structures.models.gradebook import *
from app.structures.models.course import *

from app.helpers.filestorage import *

from app.helpers.autograder import regradeSubmission

import codecs

import markdown, bleach
from markdown.extensions.attr_list import AttrListExtension

import os

@app.route('/grutor/grade/<pid>/<uid>/<subnum>')
@login_required
def grutorGradeSubmission(pid, uid, subnum):
  '''
  Function Type: View Function
  Template: grutor/gradesubmission.html
  Purpose: Display to the grader forms that will allow the grader to assign
  grades and give comments on a submission. Additionally allows the grader to
  download the files for the submission.

  Inputs:
    pid: The object ID of the problem being graded
    uid: The object ID of the user whose submission is being graded
    subnum: Which submission of the user is being graded

  Template Parameters:
    course: The course this problem is contained in
    assignment: The assignment group this problem is contained in
    problem: The problem with ID <pid>
    subnum: The submission number that is being graded
    user: The user object specified by <uid>
    submission: The submission object specified by the user, problem, and
    subnum

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    user = User.objects.get(id=uid)

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      abort(403)

    #p = Problem.objects.get(id=pid)
    #a = AssignmentGroup.objects.get(id=aid)

    submission = p.getSubmission(user, subnum)

    u = User.objects.get(id=g.user.id)

    #If this is not in progress by anyone try to claim it atomically
    if submission.status < SUBMISSION_GRADING:
      subCol = Submission._get_collection()
      if submission.partner == None:
        res = subCol.find_and_modify(query={'_id':submission.id, 'status': {"$lt": SUBMISSION_GRADING}}, update={"$set": {"status":SUBMISSION_GRADING, "gradedBy": g.user.id}})
        submission.reload()
      else:
        otherSub = submission.partnerSubmission
        subList = sorted([submission, otherSub], key=lambda x: x.id)
        res = subCol.find_and_modify(query={'_id': subList[0].id, 'status':{"$lt": SUBMISSION_GRADING}}, \
          update={'$set': {'status':SUBMISSION_GRADING, 'gradedBy': g.user.id}})
        #res = Submission.objects.exec_js(LOCK_QUERY, id=subList[0].id, uid=g.user.id)
        if res != None:
          res = subCol.find_and_modify(query={'_id': subList[1].id, 'status':{"$lt": SUBMISSION_GRADING}}, \
            update={'$set': {'status':SUBMISSION_GRADING, 'gradedBy': g.user.id}})
      if res == None:
        flash("It appears another grader has already claimed this assignment are you sure you want to grade it?", "warning")
    elif submission.gradedBy != u and not submission.status == 4:
      flash("It appears another grader has already claimed this assignment are you sure you want to grade it?", "warning")

    submission.reload()
    submission.save()

    p.save()

    return render_template("grutor/gradesubmission.html", \
                            course=c, problem=p, assignment=a, subnum=subnum,
                            user=user, submission=submission)
  except Course.DoesNotExist as e:
    abort(404)

@app.route('/grutor/finish/<pid>/<uid>/<subnum>')
@login_required
def grutorFinishSubmission(pid, uid, subnum):
  '''
  Function Type: Callback-Redirect Function
  Purpose: Save all the changes to a given submission and return to the
  list of problems.

  Inputs:
    pid: The object ID of the problem this submission belongs to
    uid: The object ID of the user this submission belongs to
    subnum: The submission number for this submission

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    user = User.objects.get(id=uid)

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      abort(403)

    #Define a function for performing closing operations
    def finish(sub):
      sub.status = max(sub.status, SUBMISSION_GRADED)
      sub.gradedBy = User.objects.get(id=g.user.id)
      sub.save()
    #End definition

    submission = p.getSubmission(user, subnum)
    finish(submission)

    #Handle the partners submission as well
    if submission.partner != None:
      finish(submission.partnerSubmission)

    p.save()

    return redirect(url_for('grutorGradelistProblem', pid=pid))
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)

@app.route('/grutor/release/<pid>/<uid>/<subnum>')
@login_required
def grutorReleaseSubmission(pid, uid, subnum):
  '''
  Function Type: Callback-Redirect Function
  Purpose: Put the submission back so that it may be chosen by another
  grader.

  Inputs:
    pid: The object ID of the problem this submission belongs to
    uid: The object ID of the user this submission belongs to
    subnum: The submission number for this submission

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    user = User.objects.get(id=uid)

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      abort(403)

    #Define function for releasing submissions
    def release(sub):
      if sub.gradedBy == None or sub.gradedBy.id == g.user.id:
        sub.status = min(submission.status, 2)
        sub.gradedBy = None
      sub.grade.save()
      sub.save()
    #End definition

    submission = p.getSubmission(user, subnum)
    #if not submission.status == 4:
    release(submission)

    if submission.partner != None:
      release(submission.partnerSubmission)

    p.save()

    return redirect(url_for('grutorGradelistProblem', pid=pid))
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)

def grutorSubArchive(p, c, a, user, sub):
  _, subnum = p.getSubmissionInfo(sub)
  with open(os.path.join(getSubmissionPath(c,a,p,user,subnum), '.gradeArchive'), 'w') as f:
    f.write("#Scores#\n")
    for sec, score in sub.grade.scores.iteritems():
      f.write(sec+":"+str(score)+"\n")
    f.write("\n#info#\n")
    f.write("isLate:" + str(sub.isLate)+"\n")
    if sub.partner == None:
      f.write("partner: None\n")
    else:
      f.write("partner: " + sub.partner.username + "\n")
    if sub.gradedBy != None: #This should always be true
      f.write("gradedBy: " + sub.gradedBy.username + "\n")
    f.write('\n')
    f.write(sub.comments)

@app.route('/grutor/grade/<pid>/<uid>/<subnum>/savegrade', methods=['POST'])
@login_required
def grutorSaveGrades(pid, uid, subnum):
  '''
  Function Type: Callback-AJAX Function
  Called By: grutor/gradesubmission.html:saveGrades()
  Purpose: Recieves a list of grades from the page and puts them into the grade
  for this submission.

  Inputs:
    pid: The problem that this grade is for
    uid: The user whose grade this is
    subnum: The submission number that is currently being graded

  POST Values: A dictionary mapping names of rubric sections to numbers.

  Outputs:
    res: The result. True if it succeeded, False if it failed, and a string
    if there was an exception.
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      return jsonify(res=False)

    #Try to get the contents
    content = request.get_json()

    #make sure we got the contents
    if content == None:
      return jsonify(res=False)

    #Define function for applying scores to a submission
    def score(sub):
      for section in content:
        sub.grade.scores[section] = content[section]

      sub.grade.save()
      sub.save()
    #End definition

    #Before we change anything make sure all changes can go through
    checkMounted()

    user = User.objects.get(id=uid)
    sub = p.getSubmission(user, subnum)

    score(sub)
    grutorSubArchive(p, c, a, user, sub)
    if sub.partner != None:
      score(sub.partnerSubmission)
      grutorSubArchive(p, c, a, sub.partner, sub.partnerSubmission)

    return jsonify(res=True, type="grades")
  except Exception as e:
    return jsonify(res=False, error=str(e))

@app.route('/grutor/grade/preview', methods=['POST'])
@login_required
def grutorPreview():
  '''
  Funcion Type: Callback-AJAX Function
  Called By: grutor/gradesubmission.html:$("#previewBtn").click(...)
  Purpose: Produce HTML from a given markdown string.

  Inputs: None

  POST Values: A json object containing one field called "text" which contains
  the markdown formatted string.

  Outputs:
    res: The resulting html generated from the markdown
  '''
  content = request.get_json()
  html = markdown.markdown(bleach.clean(content["text"]), [AttrListExtension()])
  return jsonify(res=html)

@app.route('/grutor/grade/<pid>/<uid>/<subnum>/savecomment', methods=['POST'])
@login_required
def grutorSaveComment(pid, uid, subnum):
  '''
  Function Type: Callback-AJAX Function
  Called By: grutor/gradesubmission.html:saveComments()
  Purpose: Recieves a markdown formatted string and saves it as a grader
  comment for a specified submission

  Inputs:
    pid: The problem that this grade is for
    uid: The user whose grade this is
    subnum: The submission number that is currently being graded

  POST Values: A json object containing one field called "text" which contains
  the markdown formatted string

  Outputs:
    res: The result. True if it succeeded, False if it failed, and a string
    if there was an exception.
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      return jsonify(res=False)

    #Try to get the contents
    content = request.get_json()

    #make sure we got the contents
    if content == None:
      return jsonify(res=False)

    #Define function for saving comments
    def comment(sub):
      sub.comments = content['text']
      sub.autoGraderComments = content['autotext']
      sub.save()

    user = User.objects.get(id=uid)
    sub = p.getSubmission(user, subnum)


    #Before we change anything make sure all changes can go through
    checkMounted()

    comment(sub)

    grutorSubArchive(p, c, a, user, sub)
    if sub.partner != None:
      comment(sub.partnerSubmission)
      grutorSubArchive(p, c, a, sub.partner, sub.partnerSubmission)

    #Save changes to the problem
    p.save(cascade=True)

    return jsonify(res=True, type="comments")
  except Exception as e:
    return jsonify(res=False, error=str(e))

@app.route('/grutor/toggleLate/<pid>/<uid>/<subnum>')
@login_required
def grutorToggleLate(pid, uid, subnum):
  '''
  Function Type: Callback-Redirect Function
  Purpose: Toggle the isLate flag for an assignment

  Inputs:
    pid: The object ID of the problem this submission belongs to
    uid: The object ID of the user this submission belongs to
    subnum: The submission number for this submission

  Forms Handled: None
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    user = User.objects.get(id=uid)

    #For security purposes we send anyone who isnt in this class to the index
    if not ( c in current_user.gradingCourses()):
      return jsonify(res=False)

    #Define function for releasing submissions
    def toggle(sub):
      sub.isLate = not sub.isLate
      sub.save()
    #End definition

    submission = p.getSubmission(user, subnum)
    #if not submission.status == 4:
    toggle(submission)

    if submission.partner != None:
      toggle(submission.partnerSubmission)

    p.save()

    return jsonify(res=True)
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    pass
  return jsonify(res=False)

@app.route('/grutor/regrade/<sid>')
@login_required
def grutorRegradeSubmission(sid):
  try:
    sub = Submission.objects.get(id=sid)
    p = sub.problem
    c,a = p.getParents()
    if not (c in current_user.courseInstructor):
      abort(403)

    regradeSubmission.delay(sub)

    return redirect(url_for('grutorGradelistProblem', pid=p.id))
  except Submission.DoesNotExist:
    abort(404)

@app.route('/grutor/<pid>/getFile', methods=['POST'])
@login_required
def grutorGetFiles(pid):
  try:
    problem = Problem.objects.get(id=pid)
    c, a = problem.getParents()
    if not (c in current_user.gradingCourses()):
      abort(403)

    content = request.get_json()

    filepath = getTestPath(c, a, problem)
    filepath = os.path.join(filepath, content['filename'])

    import magic

    fileType = magic.from_file(filepath, mime=True)
    fileType = fileType.split('/')

    if fileType[0] == 'text':
      try:
        f = codecs.open(filepath, encoding='utf-8', errors='ignore')
        content = f.read()
        return jsonify(majorType=fileType[0], minorType=fileType[1], content=content)
      except Exception as e:
        return jsonify(majorType=fileType[0], minorType=fileType[1], content=str(e))
        pass
      finally:
        f.close()
    else:
      return jsonify(majorType=fileType[0], minorType=fileType[1],\
       url=url_for('grutorServeFiles', pid=pid, filename=content['filename']))
  except Problem.DoesNotExist:
    abort(404)

@app.route('/grutor/<pid>/test/<filename>/serve')
@login_required
def grutorServeFiles(pid, filename):
  '''
  Function Type: Callback-Download
  Purpose: Downloads the file specified for the user.

  Inputs:
    pid: The object ID of the problem that the file belongs to
    uid: The object ID of the user the file belongs to
    subnum: The submission number that the file belongs to
    filename: The filename from the submission to download
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    #For security purposes we send anyone who isnt in this class to the index
    if not (c in current_user.gradingCourses()):
      abort(403)

    filepath = getTestPath(c, a, p)

    return send_file(os.path.join(filepath, filename))
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)


@app.route('/grutor/<pid>/test/download/<path:filename>')
@login_required
def grutorDownloadFiles(pid, filename):
  '''
  Function Type: Callback-Download
  Purpose: Downloads the file specified for the user.

  Inputs:
    pid: The object ID of the problem that the file belongs to
    uid: The object ID of the user the file belongs to
    subnum: The submission number that the file belongs to
    filename: The filename from the submission to download
  '''
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()
    #For security purposes we send anyone who isnt in this class to the index
    if not (c in current_user.gradingCourses()):
      abort(403)


    filepath = getTestPath(c, a, p)

    return send_file(os.path.join(filepath, filename), as_attachment=True)
  except (Problem.DoesNotExist, Course.DoesNotExist, AssignmentGroup.DoesNotExist):
    #If either p can't be found or we can't get its parents then 404
    abort(404)
