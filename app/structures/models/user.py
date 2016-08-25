# coding=utf-8

from app import db
from werkzeug.security import generate_password_hash, check_password_hash
from mongoengine import NULLIFY, PULL

from app.helpers.filestorage import *
from datetime import datetime

'''
User model(s)
'''
class User(db.Document):
  '''
  The information for one user of the system (Student, Grader, or Instructor)
  '''
  #General user information
  firstName = db.StringField()
  lastName = db.StringField()
  username = db.StringField(required=True, unique=True)
  email = db.EmailField()
  passHash = db.StringField(max_length=512)
  photoName = db.StringField()

  #What courses are they teaching/in
  courseStudent    = db.ListField(db.ReferenceField('Course'))
  courseGrutor     = db.ListField(db.ReferenceField('Course'))
  courseInstructor = db.ListField(db.ReferenceField('Course'))

  #Is this user an admin
  isAdmin = db.BooleanField(default=False)

  def is_authenticated(self):
    return True

  def is_active(self):
    return True

  def is_anonymous(self):
    return False

  def get_id(self):
    return unicode(self.id)

  def setPassword(self, pw):
    self.passHash = generate_password_hash(pw)

  def checkPassword(self, pw):
    return check_password_hash(self.passHash, pw)

  def gradingCourses(self):
    out = self.courseGrutor + self.courseInstructor
    out = list(set(out))
    return out

  def gradingActive(self):
    out = self.grutorActive() + self.instructorActive()
    out = list(set(out))
    return out
  #replace next three with user active
  def studentActive(self):
    activeCourses = []
    for course in self.courseStudent:
      try:
        if course.isActive:
          activeCourses.append(course)
      except:
        pass
    return activeCourses#[x for x in self.courseStudent if x.isActive]

  def grutorActive(self):
    activeCourses = []
    for course in self.courseGrutor:
      try:
        if course.isActive:
          activeCourses.append(course)
      except:
        pass
    return activeCourses
    #return [x for x in self.courseGrutor if x.isActive]

  def instructorActive(self):
    activeCourses = []
    for course in self.courseInstructor:
      try:
        if course.isActive:
          activeCourses.append(course)
      except:
        pass
    return activeCourses
    #return [x for x in self.courseInstructor if x.isActive]

  def keyOfUsername(self):
    '''Because keys for dictionaries can't contain some characters we must
    clean the username of the user anytime we put it in a dictionary field'''
    tmp = re.sub(r'\$', '&dlr;', self.username)
    return re.sub(r'\.', '&dot;', tmp)

def userFromKey(key):
  tmp = re.sub(r'&dlr;', '$', key)
  return re.sub(r'&dot;', '.', tmp)

class RecoverAccount(db.Document):
  '''
  An object for recovering an account
  '''

  user = db.ReferenceField('User')
  requestIP = db.StringField(default="")
  created = db.DateTimeField(default=datetime.utcnow())
