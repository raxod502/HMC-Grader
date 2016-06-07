import os
from pick import pick


SUBMISSIONS_PATH = os.path.join(os.environ['HOME'],"GraderStorage","submissions")
fileList = []

for root, dirs, files in os.walk(SUBMISSIONS_PATH, topdown=False):
    for name in files:
    	filename, fileExtension = os.path.splitext(name)
    	if fileExtension == ".py":
    		path = os.path.join(root,name)
    		fileList.append(path)
    		print name
