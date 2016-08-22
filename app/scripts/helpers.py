from app.structures.models.user import *
from app.structures.models.course import *

def query_yes_no(question, default="yes"):
  """Ask a yes/no question via raw_input() and return their answer.

  "question" is a string that is presented to the user.
  "default" is the presumed answer if the user just hits <Enter>.
      It must be "yes" (the default), "no" or None (meaning
      an answer is required of the user).

  The "answer" return value is True for "yes" or False for "no".
  """
  valid = {"yes": True, "y": True, "ye": True,
           "no": False, "n": False}
  if default is None:
    prompt = " [y/n] "
  elif default == "yes":
    prompt = " [Y/n] "
  elif default == "no":
    prompt = " [y/N] "
  else:
    raise ValueError("invalid default answer: '%s'" % default)

  while True:
    print question + prompt
    choice = raw_input().lower()
    if default is not None and choice == '':
      return valid[default]
    elif choice in valid:
      return valid[choice]
    else:
      print "Please respond with 'yes' or 'no' (or 'y' or 'n').\n"

def createUsername(firstName, lastName):
  firstName = firstName.lower()
  lastName = lastName.lower()
  #Try increasing the length of the first name to remove conflicts
  for i in range(1,len(firstName)+1):
    try:
      tryName = firstName[:i]+lastName
      u = User.objects.get(username=tryName)
    except User.DoesNotExist:
      return firstName[:i]+lastName

  #If we didn't get a successful name here append numbers
  conflictNumber = 1
  while True:
    try:
      tryName = firstName+lastName+str(conflictNumber)
      u = User.objects.get(username=tryName)
      conflictNumber += 1
    except:
      return firstName+lastName+str(conflictNumber)

def addUser(firstName, lastName, email=None, password="asdf"):
  '''Creates a user with a distinct username'''
  #create the user
  u = User()
  u.username = email#createUsername(firstName, lastName)
  u.firstName = firstName
  u.lastName = lastName
  u.email = email
  u.setPassword(password)
  u.save()
  #return the user when we are done
  return u

def addOrGetUser(firstName, lastName, email=None, password="asdf"):
  '''If we are given an email try to get an existing user otherwise create
  a new user'''
  if email != None:
    try:
      u = User.objects.filter(email=email)
      if len(u) > 0:
        return u[0]
    except User.DoesNotExist:
      pass

  return addUser(firstName, lastName, email, password)

def addOrGetByUsername(username, firstName, lastName, email=None, password="asdf"):
  try:
    u = User.objects.get(username=email)#username)
    return u
  except User.DoesNotExist:
    u = User()
    u.username = email#username
    u.firstName = firstName
    u.lastName = lastName
    u.email = email
    u.setPassword(password)
    u.save()
    return u

def courseInList(course, courseList):
  try:
    if course in courseList:
      return True
    else:
      return False
  except:
    return None


def getCourse(semester, name):
  try:
    c = Course.objects.get(semester=semester, name=name)
    return c
  except Course.DoesNotExist:
    return None

def getUser(username):
  try:
    u = User.objects.get(username=username)
    return u
  except User.DoesNotExist:
    return None
