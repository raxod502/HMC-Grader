import sys

from app.scripts.helpers import *
from app.models.structures.user import *

if __name__ == "__main__":
  username = raw_input("Username: ")
  
  user = getUser(username)

  if user == None:
    print "Could not find the user you specified"
    sys.exit(1)

  newPassword = raw_input("New Password: ")

  user.setPassword(newPassword)
  user.save()