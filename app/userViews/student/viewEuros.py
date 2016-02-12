# -*- coding: utf-8 -*-

#import the app and the login manager
from app import app

from flask import g, request, render_template, redirect, url_for, flash, send_file, abort
from flask import jsonify
from flask.ext.login import login_user, logout_user, current_user, login_required

from app.structures.models.user import *
from app.structures.models.gradebook import *
from app.structures.models.course import *

from app.plugins.latework import getLateCalculators


from app.helpers.gradebook import getStudentAssignmentScores, getStudentAuxScores, getStudentScoresNoCalculator

@app.route('/student/euros/<cid>')
@login_required
def viewEuros(cid):
  '''
  Function Type: View Function
  Purpose: Show the user their euros

  Inputs: None
  '''
  course = Course.objects.get(id=cid)
  return render_template('student/vieweuros.html', course=course, cid=cid)


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

@app.route('/student/renderEuros', methods=['POST'])
@login_required
def studentRenderEuros():
  try:
    content = request.get_json()
    c = Course.objects.get(id=content['cid'])
    u = User.objects.get(id=current_user.id)

    assignmentScores = getStudentScoresNoCalculator(c, u)

    eurosUsed = 0
    outString = "<tr><th>Your Euros</th>"

    for assignment, a in zip(assignmentScores, c.assignments):
      #If this assignment doesn't have any problems, skip it
      if len(assignment) == 0:
        outString += "<td class='active'></td>"
        continue

      assignmentContainsLateProblems = False

      for problem, p in zip(assignment, a.problems):
        if problem == None:
          #If there was no submission link to the make blank page
          outString += "<td class='active'></td>"          
          continue
        else:
          if problem['isLate']:
            outString += "<td style='text-align:center' class='danger'><span class='octicon octicon-check'></span></td>"
            assignmentContainsLateProblems = True
          else:
            outString += "<td class='success'></td>"

      #once all the problems have been run through, calculate if a euro was used
      if assignmentContainsLateProblems:
        eurosUsed += 1
    
    for group in c.gradeBook.auxillaryGrades:
      if len(group.columns) == 0:
        outString += "<td class='active'></td>"
        continue

      for col in group.columns:
        outString += "<td class='active'></td>"

    outString += "<td>%d</td></tr>" % (eurosUsed)
    return jsonify(res=outString, cid=str(c.id))

  except (Course.DoesNotExist,User.DoesNotExist):
    abort(404)
  except Exception as e:
    return jsonify(res=str(e))
