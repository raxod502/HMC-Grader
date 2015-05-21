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


from app.helpers.gradebook import getStudentAssignmentScores, getStudentAuxScores

@app.route('/student/grades/<cid>')
@login_required
def viewGrades(cid):
  '''
  Function Type: View Function
  Purpose: Show the user thier grades

  Inputs: None
  '''
  course = Course.objects.get(id=cid)
  return render_template('student/viewgrades.html', course=course, cid=cid)


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

@app.route('/student/renderGrade', methods=['POST'])
@login_required
def studentRenderGrades():
  try:
    content = request.get_json()
    c = Course.objects.get(id=content['cid'])
    u = User.objects.get(id=current_user.id)

    assignmentScores = getStudentAssignmentScores(c, u)

    userCourseScore = 0

    outString = "<tr><th>Your Scores</th>"
    # <td>{{link to problem grading}}</td>
    for assignment, a in zip(assignmentScores, c.assignments):
      #If this assignment doesn't have any problems we put a blank column in
      if len(assignment) == 0:
        outString += "<td class='active'></td>"
        continue

      for problem, p in zip(assignment, a.problems):
        if problem == None:
          #If there was no submission link to the make blank page
          outString += "<td class='active'>"
          outString += "0.00"
          outString += "</td>"
        else:
          highlight = createHighlight(problem)
          if 'finalTotalScore' in problem:
            points =  problem['finalTotalScore']
            userCourseScore += problem['finalTotalScore']
          else:
            points = problem['rawTotalScore']
            userCourseScore += problem['rawTotalScore']

          maxPoints = p.gradeColumn.maxScore
          cellTemplate = "<td %s>%.2f</td>" % (highlight, points)
          outString += cellTemplate

    for group in c.gradeBook.auxillaryGrades:
      if len(group.columns) == 0:
        outString += "<td class='active'></td>"
        continue

      for col in group.columns:
        score = col.scores.setdefault(u.keyOfUsername(), None)
        if score:
          outString += "<td>%.2f</td>" % (score.totalScore())
          userCourseScore += score.totalScore()
        else:
          outString += "<td>%.2f</td>" % (0)

    outString += "<td>%.2f</td></tr>" % (userCourseScore)
    return jsonify(res=outString, cid=str(c.id))

  except (Course.DoesNotExist,User.DoesNotExist):
    abort(404)
  except Exception as e:
    return jsonify(res=str(e))
