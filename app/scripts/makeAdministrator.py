import sys

from app.scripts.helpers import *
from app.structures.models.user import *
from app.structures.models.course import *

if __name__ == "__main__":
  username = raw_input("Username: ")
  
  user = getUser(username)

  if user == None:
    print "Could not find the user you specified"
    sys.exit(1)

  user.isAdmin = True
  
  #We need to retroactively add them to all courses
  user.courseInstructor = Course.objects
  user.save()

  print user.username + " is now an admin"