# -*- coding: utf-8 -*-

'''
This module supports all of the forms for the site
'''

from flask.ext.wtf import Form
from wtforms import TextField, PasswordField, BooleanField, SelectField
from wtforms import TextAreaField, BooleanField, FileField, DecimalField, IntegerField
from wtforms.validators import Required, EqualTo, Optional
from wtforms.validators import Length, Email


# '''
# Account management forms
# '''
class SignInForm(Form):
  '''
  This form handles logging in a student. The user must enter their username and
  password and if they wish to store their credentials in a cookie they can
  click the remember me button.
  '''
  username = TextField('Username',validators=[Required('Please provide a username')])
  password = PasswordField('Password')
  remember = BooleanField('Remember Me')

class ChangePasswordForm(Form):
  '''
  This form allows a user to change their password. They must enter their old
  password and then enter a new password twice.
  '''
  oldPassword = PasswordField('Old Password', validators=[Required()])
  newPassword = PasswordField('New Password', validators=[Required()])
  newPasswordConf = PasswordField('Confirm New Password', validators=[Required()])

class UserSettingsForm(Form):
  firstName = TextField('First Name')
  lastName = TextField('Last Name')
  email = TextField('Email')
  photo = FileField('Profile Photo')


class ResetPasswordForm(Form):
  newPass = PasswordField('New Password', validators=[Required()])
  newPassConf = PasswordField('Confirm New Password', validators=[Required()])

# '''
# Admin panel forms
# '''

class CreateCourseForm(Form):
  '''
  This form handles the creation of a new course.
  '''
  name = TextField("Course Name")
  semester = TextField("Semester")

class CreateUserForm(Form):
  '''
  This form handles the creation of a new user
  '''
  firstName = TextField("First Name")
  lastName = TextField("Last Name")
  username = TextField("Username")
  email = TextField("Email")
  password = PasswordField("Password")


# '''
# Instructor forms
# '''

class CreateAssignmentForm(Form):
  '''
  This form handles the creation of a new assignment group
  '''
  name = TextField("Assignment Group Name", validators=[Required()])

class AddUserCourseForm(Form):
  '''
  This form is for adding new users to a course
  '''
  uname = TextField("Username", validators=[Required()])

class ProblemOptionsForm(Form):
  '''
  This form handles all of the options for a form.
  It includes a hidden time field which contains a UTC ISO-formatted string
  each time the date or time fields change. This allows the system to be
  timezone independant.
  '''
  name = TextField("Problem Name")
  date = TextField("Due Date")
  time = TextField("Due Time")
  gradeNotes = TextField("Grading Notes URL")
  problemPage = TextField("Problem Description URL")
  requiredFiles = TextField("Do not autograde without: (separated by commas)")
  strictFiles = TextField("Do not accept without: (filenames separated by commas)")
  allowPartners = BooleanField("Allow Partners")
  releaseAutoComments = BooleanField("Release autograder comments")
  autoGradeOnly = BooleanField("Finish grading after autograder (Releases scores and comments)")
  isOpen = BooleanField("Is the problem open for submissions")
  hiddentime = TextField("")
  hiddenRubric = TextField("")

class AddTestForm(Form):
  '''
  This form adds a test to a problem.
  '''
  testFile = FileField("File")
  testType = SelectField("Language")

class CreateGradebookGroupForm(Form):
  groupName = TextField("Gradebook Group Name", validators=[Required()])

class CreateGradeColumnForm(Form):
  name = TextField("Grade Column Name", validators=[Required()])
  group = SelectField("Gradebook Group")

class CourseSettingsForm(Form):
  '''
  This form handles changing course settings. (It may possibly be expanded in
  the future when we decide on more settings)
  '''
  anonymousGrading = BooleanField("Use anonymous grading (hide student usernames)")
  anonymousGrutors = BooleanField("Hide grutor usernames from students")
  homepage = TextField("Course Homepage (include http:// for external sites)")
  latePolicy = SelectField("Late Work Policy")
  gracePeriod = IntegerField("Late Work Grace Period (minutes)")

class ReuploadTestForm(Form):
  testFile = FileField("File")


# '''
# Grutor forms
# '''

class ClockInForm(Form):
  course = SelectField("Course")
  location = SelectField("Location", choices=[\
  ("LAC Labs", "LAC Labs"),\
  ("Balloon/Birch Labs", "Balloon/Birch Labs"),
  ("Platt Lounge", "Platt Lounge"),
  ("Other", "Other")])
  other = TextField("Other Location")

class ClockOutForm(Form):
  comments = TextAreaField("Comments")

# '''
# Student forms
# '''

class SubmitAssignmentForm(Form):
  '''
  This form handles taking a students files and assigning them a partner.
  '''
  files = FileField("Files")
  partner = SelectField("Partner")

class AttendanceForm(Form):
  '''
  This form allows a student to sign into the system for lab
  '''
  course = SelectField("Course")

# '''
# Page Forms
# '''

class PageImageForm(Form):
  photo = FileField("File")

# '''
# Feedback forms
# '''

class FeedbackForm(Form):
  useName = BooleanField("Attach my name to this comment", default=True)
  comment = TextAreaField("Comment")
