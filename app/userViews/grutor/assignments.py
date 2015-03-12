# coding=utf-8

'''
This module supports the Grader Assignment overview page
'''

from app import app

from flask import g, request, render_template, redirect, url_for, flash, send_file, abort
from flask import jsonify
from flask.ext.login import login_user, logout_user, current_user, login_required

from app.structures.models.user import *
from app.structures.models.gradebook import *
from app.structures.models.course import *

from app.helpers.filestorage import *

import os

@app.route('/grutor/assignments/<cid>')
@login_required
def grutorAssignments(cid):
  '''
  Function Type: View Function
  Template: grutor/assignments.html
  Purpose: Display all of the assignment groups and problems in those groups
  for the course specified by <cid>.

  Inputs:
    cid: A course object ID

  Template Parameters:
    course: The course object specified by <cid>

  Forms Handled: None
  '''
  try:
    c = Course.objects.get(id=cid)
    #For security purposes we send anyone who isnt grading this class to the index
    if not ( c in current_user.gradingCourses()):
      abort(403)

    return render_template("grutor/assignments.html", course=c)
  except Course.DoesNotExist as e:
    abort(404)
