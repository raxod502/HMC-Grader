# coding=utf-8

'''
This module handles rendering the gradebook and its associated functions such
as download and handling rendering rows of the table
'''

#Import the app
from app import app

#Import needed flask functions
from flask import g, render_template, redirect, url_for, flash, jsonify, abort
from flask import request, after_this_request, send_file
from flask.ext.login import current_user, login_required

#Import the models we need on these pages
from app.structures.models.user import *
# from app.structures.models.gradebook import *
from app.structures.models.course import *

#Import forms for this page
# from app.structures.forms import CreateGradeColumnForm, CreateGradebookGroupForm

#Import app helpers
from app.helpers.gradebook import getStudentAssignmentScores, getStudentAuxScores

#Import other python helpers
import tempfile, csv

@app.route('/eurobook/<cid>/<bool:instr>')
@login_required
def viewEurobook(cid, instr):
  '''
  Function Type: View Function
  Template: common/eurobook.html
  Purpose: Display all of the grades for this course. Allow for creation of
  arbitrary submission entries.

  Inputs:
    cid: The object ID of the course to display

  Template Parameters: TODO

  Forms Handled: TODO
  '''
  try:
    c = Course.objects.get(id=cid)
    if instr and not c in current_user.courseInstructor:
      abort(403)
    elif not instr and not c in current_user.gradingCourses():
      abort(403)

    #Get the users for this course
    s = User.objects.filter(courseStudent=c)

    s = list(s)
    s.sort(key=lambda x:x.username)
    uids = [str(u.id) for u in s]

    return render_template('common/eurobook.html', course=c, uids=uids,\
                      instructor=instr)
  except Course.DoesNotExist:
    abort(404)

@app.route('/eurobook/download/<cid>/<bool:raw>')
@login_required
def serveEurobook(cid, raw):
  try:
    course = Course.objects.get(id=cid)

    if not course in current_user.courseInstructor:
      abort(403)

    csvf = tempfile.NamedTemporaryFile()

    writer = csv.writer(csvf, delimiter=",", quotechar="\"")

    #Put the main headers on
    row = ['Name', 'Username']
    for a in course.assignments:
      row += [a.name]
    row += ['Total Euros']
    writer.writerow(row)

    #Do the user rows
    students = User.objects.filter(courseStudent=course)

    for s in students:
      if course.anonymousGrading:
        row = [(str(s.firstName) + ' ' + str(s.lastName)), \
                (s.username+ ' (' + course.getIdentifier(s.username) + ')')]
      else:
        row = [(str(s.firstName) + ' ' + str(s.lastName)), s.username]

      euroCount, lateAssignments = course.getEuroCountAndLateAssignmentsList(s)
      
      for a in course.assignments:
        if len(a) == 0:
          row += ['N/A']
          continue
        else:
          if a in lateAssignments:
            row += [1]
          else:
            row += [0]
      
      row += [euroCount]
      writer.writerow(row)

    #Be kind rewind the file
    csvf.seek(0)

    return send_file(csvf,as_attachment=True, attachment_filename='euros.csv', cache_timeout=50)

  except Course.DoesNotExist:
    abort(404)

def createHighlight(gradeSpec):
  if 'highlight' in gradeSpec:
    if gradeSpec['highlight'] == 'red':
      return "class='danger'"
    elif gradeSpec['highlight'] == 'yellow':
      return "class='warning'"
    elif gradeSpec['highlight'] == 'blue':
      return "class='info'"
    elif gradeSpec['highlight'] == 'green':
      return "class='success'"
  else:
    return ""

@app.route('/eurobook/<cid>/<bool:instr>/renderEuros', methods=['POST'])
@login_required
def commonRenderEuros(cid, instr):
  try:
    content = request.get_json()
    c = Course.objects.get(id=cid)
    u = User.objects.get(id=content['uid'])

    #If we are accessing the instructor version check that they are an instr
    if instr and not c in current_user.courseInstructor:
      abort(403)

    if not c in current_user.gradingCourses():
      abort(403)

    euroCount, lateAssignments = c.getEuroCountAndLateAssignmentsList(u)

    # Username
    outString = "<tr>"
    outString += "<td>"
    if instr:
      outString += u.username
      if c.anonymousGrading:
        outString += " (" + c.getIdentifier(u.keyOfUsername()) + ")"
    else:
      if c.anonymousGrading:
        outString += c.getIdentifier(u.keyOfUsername())
      else:
        outString += u.username
    outString += "</td>"

    # Total euros used
    outString += "<td>%d</td>" % (euroCount)

    # Summary by assignment
    for a in c.assignments:
      if a in lateAssignments:
        outString += "<td style='text-align:center' class='danger'><span class='octicon octicon-check'></span></td>"
      else:
        outString += "<td></td>"

    # Close the row
    outString += "</tr>"

    return jsonify(res=outString)

  except (Course.DoesNotExist,User.DoesNotExist):
    abort(404)
