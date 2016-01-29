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

@app.route('/grutor/problem/<pid>/status1')
@login_required
def grutorGetStatus_Assignments(pid):
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()

    if not (c in current_user.gradingCourses()):
      abort(403)

    if c.name != "CS5G":
      u, i, d = p.getStatusCount()
      return jsonify(u=u, i=i, d=d)
    # Special case to avoid calculations for CS5G
    else:
      return jsonify(u=0, i=0, d=0)
  except Problem.DoesNotExist:
    abort(404)

@app.route('/grutor/problem/<pid>/status2')
@login_required
def grutorGetStatus_Problems(pid):
  try:
    p = Problem.objects.get(id=pid)
    c,a = p.getParents()

    if not (c in current_user.gradingCourses()):
      abort(403)

    u, i, d = p.getStatusCount()
    return jsonify(u=u, i=i, d=d)
  except Problem.DoesNotExist:
    abort(404)