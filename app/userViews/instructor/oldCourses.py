# coding=utf-8

'''The module handles displaying links to all of the old courses.

View Function: oldCourses (instructor/oldCourses.html)

Redirect Functions: TODO

AJAX Fuctions: TODO
'''

#Import the app
from app import app

#Import needed flask functions
from flask import g, render_template, redirect, url_for, flash, jsonify, abort
from flask import request
from flask.ext.login import current_user, login_required

#Import the models we need on these pages
from app.structures.models.user import *
from app.structures.models.course import *

@app.route('/instructor/archived_courses')
@login_required
def oldCourses():
  '''
  Function Type: View Function
  Template: instructor/oldCourses.html
  Purpose: Allows an instructor to view archived courses.

  Inputs:
    none

  Template Parameters:
    courses: A list of archived courses
  '''

  courses = list(set(current_user.courseInstructor) - set(current_user.instructorActive()))
  return render_template("instructor/oldCourses.html", courses=courses)
