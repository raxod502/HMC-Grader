import sys

from app.models.structures.user import *
from app.models.structures.course import *

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