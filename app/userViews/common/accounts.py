# -*- coding: utf-8 -*-

'''
This module handles login, logout, and settings for user accounts
'''

#import the app and the login manager
from app import app, loginManager

#Import flask functions we need
from flask import g, request, render_template, redirect, url_for, flash
from flask import abort, send_file
from flask.ext.login import login_user, logout_user, current_user, login_required

#Function for securing uploaded files
from werkzeug import secure_filename

#Import the models we need for these pages
from app.structures.models.user import User, RecoverAccount

#Import the forms we need for these pages
from app.structures.forms import SignInForm, ChangePasswordForm
from app.structures.forms import UserSettingsForm, ResetPasswordForm

#Import app helper functions for these pages
from app.helpers.filestorage import getUserPhotoDir, getUserPhotoPath
from app.helpers.filestorage import ensurePathExists

#Generic python imports
import os, bleach

LOGIN_ERROR_MSG = "Invalid Username/Password"


@loginManager.user_loader
def load_user(id):
  '''
  Function Type: Boilerplate
  Purpose: This function takes the user ID stored in the session cookie and
  converts it into a User object by performing a database query.
  '''
  return User.objects.get(id=id)

@app.route('/login', methods=['POST', 'GET'])
def login():
  '''
  Function Type: View Function, Form handler
  Template: accounts/login.html
  Purpose: Handle the login of a user and provide feedback when login fails.

  Inputs: None

  Template Parameters:
    form: A form of the class SignInForm. This takes the username and password
    of the user.
    active_pate: A string naming the active page. This is for higlighting the
    active page in the nav-bar.

  Forms Handled:
    SignInForm: Uses this form to determine if the user has the credentials to
    access the account. If an error occurs the appropriate error fields are
    filled in and the form is sent back to the template.
  '''
  #If the user is already authenticated we are done here just go to the index
  if g.user is not None and g.user.is_authenticated:
    flash("User is alread logged in", "warning")
    return redirect(url_for('index'))

  #If the form is being submitted (we get a POST request) handle the login
  if request.method == 'POST':
    form = SignInForm(request.form)
    if form.validate():
      try:
        user = User.objects.get(username=form.username.data)
        passMatch = user.checkPassword(form.password.data)
        #Check for matching password hashes
        if not passMatch:
          flash(LOGIN_ERROR_MSG, "error")
          return render_template("accounts/login.html", form=form, \
                                  active_page="login")

        #Validated so login the user (If the asked to be remembered tell
        #flask-login to handle that)
        login_user(user, remember=form.remember.data)
        #set the session global user variable
        g.user = current_user
        return redirect(url_for('index'))

      except User.DoesNotExist:
        flash(LOGIN_ERROR_MSG, "error")
        return render_template("accounts/login.html", form=form, \
                                active_page="login")

  #If it wasn't a form submission just render a blank form
  return render_template("accounts/login.html", form=SignInForm(), \
                          active_page="login")


@app.route('/recover', methods=['POST','GET'])
def requestRecovery():

  if request.method == 'POST':
    form = SignInForm(request.form)
    if form.validate():
      try:
        user = User.objects.get(username=form.username.data)
        if user.email == None or len(user.email) == 0:
          flash("No email address on file for this user", "error")
          return redirect(url_for('login'))

        rec = RecoverAccount()
        rec.user = user
        rec.requestIP = str(request.environ['REMOTE_ADDR'])
        rec.save()

        #Send an email to recover the password
        import smtplib
        from email.mime.text import MIMEText

        messageText = """\
        <html>
        <head></head>
        <body>
        <p>It looks like you requested a link to reset your password. <a href='
        """
        messageText += url_for('recovery', rid=rec.id, _external=True)
        messageText += """'>Here</a> is the link. If you didn't request this link
        and you think this has been recieved in error please contact your system
        administrator.</p>
        </body>
        </html>"""

        msg = MIMEText(messageText,'html')
        msg['Subject'] = 'Password reset request'
        msg['From'] = app.config['SYSTEM_EMAIL_ADDRESS']
        msg['To'] = user.email

        s = smtplib.SMTP(app.config['SMTP_SERVER'])
        s.sendmail(app.config['SYSTEM_EMAIL_ADDRESS'], [user.email], msg.as_string())

        flash("Password reset request sent", "success")
        return redirect(url_for('login'))
      except User.DoesNotExist:
        flash("The user you specified could not be found.", "error")
        return redirect(url_for('login'))
    else:
      for v in form.errors.values():
        flash(v[0], "error")
  return render_template("accounts/login.html")

@app.route('/recover/<rid>', methods=['POST', 'GET'])
def recovery(rid):
  from datetime import datetime, timedelta
  try:
    rec = RecoverAccount.objects.get(id=rid)
    diff = datetime.utcnow() - rec.created

    if diff > timedelta(hours=2):
      flash("This recovery ticket has expired")
      return redirect(url_for('login'))

    if request.method == 'POST':
      form = ResetPasswordForm(request.form)
      if form.validate():
        if form.newPass.data == form.newPassConf.data:
          rec.user.setPassword(form.newPass.data)
          rec.user.save()
          flash("Password Reset")
          return redirect(url_for('index'))
        else:
          flash("Passwords must match", "warning")
          return redirect(url_for('recovery', rid=rid))
      else:
        flash("Validation error", "warning")
        return redirect(url_for('recovery', rid=rid))
    else:
      return render_template('accounts/recover.html', pwform=ResetPasswordForm(), rid=rid)
  except RecoverAccount.DoesNotExist:
    flash("This recovery ticket does not exist", "warning")
  return redirect(url_for('login'))

@app.route('/logout')
@login_required
def logout():
  '''
  Function Type: Callback-Redirect Function
  Purpose: Log out the current user and redirect to the index

  Inputs: None

  Forms Handled: None
  '''
  logout_user()
  g.user = current_user
  flash("You have been logged out", "success")
  return redirect(url_for('index'))

#TODO refactor this. possibly use javascript and a smaller callback rather than this large elif mess
@app.route('/settings', methods=['POST', 'GET'])
@login_required
def userSettings():
  '''
  Function Type: View Function
  Template: accounts/settings.html
  Purpose: Display current account information as well as provide forms for
  changing account information.

  Inputs: None

  Template Parameters:
    pwform: PasswordChangeForm for allowing the user to change their password
    fnform: Form for changing first names
    lnform: Form for changing last names
    eform: Form for changing email addresses
    active_page: Identifier for highlighting the active page in the nav-bar

  Forms Handled:
    PasswordChangeForm: Confirms that the old password matches and that the two
    new passwords match then changes the users password.
    ChangeFirstNameForm: Changes the users first name
    ChangeLastNameForm: Changes the users last name
    ChangeEmailForm: Changes the users email
  '''
  if request.method == 'POST':
    #Find which form was submitted
    if request.form['btn'] == 'changepasswd':
      form = ChangePasswordForm(request.form)
      if form.validate():
        user = current_user
        pass_match = user.checkPassword(form.oldPassword.data)
        if not pass_match:
          form.oldPassword.errors.append("Please confirm your old password")
          return render_template("accounts/settings.html", pwform=form,\
                                  active_page="userSettings",\
                                  settingsForm=UserSettingsForm())
        elif form.newPassword.data != form.newPasswordConf.data:
          form.newPasswordConf.errors.append("Passwords must match")
          return render_template("accounts/settings.html", pwform=form,\
                                  active_page="userSettings",\
                                  settingsForm=UserSettingsForm())
        else:
          user.setPassword(form.newPassword.data)
          user.save()
          return redirect(url_for('userSettings'))
  return render_template("accounts/settings.html", pwform=ChangePasswordForm(),\
                          active_page="userSettings", \
                          settingsForm=UserSettingsForm())

@app.route('/settings/image/<uid>')
def sendProfilePicture(uid):
  try:
    user = User.objects.get(id=uid)
    if user.photoName != None:
      return send_file(getUserPhotoPath(user))
    else:
      return redirect(url_for('static', filename='images/defaultUser.png'))
  except Exception as e:
    return redirect(url_for('static', filename='images/defaultUser.png'))

@app.route('/settings/update', methods=['POST'])
@login_required
def userUpdateSettings():
  if request.method == 'POST':
    form = UserSettingsForm(request.form)
    if form.validate():
      user = current_user
      user.firstName = bleach.clean(form.firstName.data)
      user.lastName = bleach.clean(form.lastName.data)
      if form.email.data == "None":
        user.email = None
      else:
        user.email = bleach.clean(form.email.data)

      f = request.files.getlist('photo')[0]
      if len(f.filename) > 0:
        if user.photoName != None:
          #Remove the existing photo
          os.remove(getUserPhotoPath(user))
        #We have to upload a new photo
        photoName = secure_filename(f.filename)
        name, extension = os.path.splitext(photoName)
        ensurePathExists(getUserPhotoDir())
        f.save(os.path.join(getUserPhotoDir(), str(g.user.id)+extension))
        user.photoName = str(g.user.id)+extension

      user.save()
      flash("Updated user information", "success")
      return redirect(url_for('userSettings'))
