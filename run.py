from app import app
from app import db
from app.structures.models.user import User
import sys

if __name__ == "__main__":
  try:
  	User.objects.get(username="admin")
  except User.DoesNotExist:
  	admin = User()
  	admin.username = "admin"
  	admin.setPassword("xc1I20zT(Tzf")
  	admin.isAdmin = True
  	admin.save()

  # command line flag for test mode
  # run $ venv/bin/python run.py -t     to run in debug mode
  # do NOT do this on production server
  debug = False
  if len(sys.argv)>1:
    if str(sys.argv[1]) == '-t':
      print "##### Warning: running in debug mode #####"
      debug = True

  app.run(host="0.0.0.0", port=5050, debug=debug)


  # 
  # command to kill the network connection
  # sudo fuser 5050/tcp -k
  # this is some kind of kill command...
  #
