from app import app
from app import db
from app.structures.models.user import User


try:
	User.objects.get(username="admin")
except User.DoesNotExist:
	admin = User()
	admin.username = "admin"
	admin.setPassword("xc1I20zT(Tzf")
	admin.isAdmin = True
	admin.save()

app.run(host="0.0.0.0", port=5050, debug=False)#change to false


# 
# command to kill the network connection
# sudo fuser 5050/tcp -k
# this is some kind of kill command...
#
