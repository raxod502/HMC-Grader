import os
import sys
from pick import pick

from shutil import copyfile


import picobotgrader as pg


SUBMISSIONS_PATH = os.path.join(os.environ['HOME'],"GraderStorage","submissions")


def getPaths(path):
	"""wrapper for os.listdir to remove hidden files and turn folder names into full paths"""
	folders = os.listdir(path)
	paths = []
	for folder in folders:
		if not folder.startswith('.'):
			pathName = os.path.join(path,folder)
			paths.append(pathName)
	return paths

def getSubFolders(folders):
	"""returns a list of all subdirectories in folderList
	if folderList has folders A,B  A has 1,2,3  and B has x,y,z subdirectories will be 1,2,3,x,y,z
	"""
	subDirectories = []
	for folder in folders:
		paths = getPaths(folder)
		for path in paths:
			subDirectories.append(path)
	return subDirectories

def pickFolder(folders,label):
	"""pick filter out of list of subdirectories"""#check for matches
	displayList = ['all']
	for folder in folders:
		displayName = os.path.basename(os.path.normpath(folder))
		displayList.append(displayName)
	folder, index = pick(displayList, label)
	if index == 0:
		return folders
	else:
		return [folders[index-1]]

src = "/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/ahector/1/hw0pr3.txt"
target = "/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/.test/hw0pr3.txt"
copyfile(src, target)
print pg.runTests(None,"/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/.test/hw0pr3tests.txt"
,10)

"""
filters = ["Semester", "Class", "Assignment", "Problem", "Student"]
subFolders = getPaths(SUBMISSIONS_PATH)
for filterName in filters:
	filteredList = pickFolder(subFolders,"Choose "+filterName)
	subFolders = getSubFolders(filteredList)

paths = []
for submission in filteredList:
	mostRecent = max(os.listdir(submission))
	path = os.path.join(submission,mostRecent)
	paths.append(path)

for submission in paths:
	try:
		print pg.runTests(None,submission+"/hw0pr3.txt",10)
	except:
		print 'failed to find test'

"""