# coding=utf-8

#Import the app
from app import app

#Import needed flask functions
from flask import g, render_template, redirect, url_for, flash, jsonify, abort
from flask import request
from flask.ext.login import current_user, login_required

#Import the models we need on these pages
from app.structures.models.user import *
from app.structures.models.gradebook import *
from app.structures.models.course import *


@app.route('/instructor/randomStudent/<cid>')
@login_required
def instructorRandomStudent(cid):
  '''
  Function Type: View Function
  Template: instructor/randomStudent.html
  Purpose: Allows an instructor to choose random students in class

  Inputs:
    cid: The object ID of the course to choose students from

  Template parameters:
    userInfo: a list of user tuples including
              (uid, uname, first name, last name)
  '''

  try:
    c = Course.objects.get(id=cid)

    if not c in current_user.courseInstructor:
      abort(403)

    userList = [(str(u.id), u.username, u.firstName, u.lastName) \
                for u in User.objects.filter(courseStudent=c)]

    return render_template("instructor/randomStudent.html", userList=userList)
  except Course.DoesNotExist:
    abort(404)
