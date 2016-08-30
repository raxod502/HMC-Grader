import os
import sys
from pick import pick

from shutil import copyfile



SUBMISSIONS_PATH = os.path.join(os.environ['HOME'],"GraderStorage","submissions")
COPY_PATH = os.environ['HOME']
def removeDuplicates(seq):
    seen = set()
    seen_add = seen.add
    return [x for x in seq if not (x in seen or seen_add(x))]

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
	displayList.pop(0)
	if index == 0:
		return displayList,folders
	else:
		return [displayList[index-1]],[folders[index-1]]

def createFolder(folderPath, copyPath):
		newFolderName = os.path.basename(folderPath)
		newFolderPath = os.path.join(copyPath, newFolderName)
		if not os.path.exists(newFolderPath):
			os.makedirs(newFolderPath)


def copyFolder(path,copyPath,selectedFilters):
	
	if len(selectedFilters)==0:
		print path,copyPath
		return 
	else:

		currentFilter = set(selectedFilters.pop(0))
		availableFolders = set(map(os.path.basename, getPaths(path)))
		filteredFolderNames = list(currentFilter.intersection(availableFolders))
		print '#######', filteredFolderNames,'#######',currentFilter,'#######',filteredFolderNames

		for folderName in filteredFolderNames:
			newPath = os.path.join(path, folderName)
			newCopyPath = os.path.join(copyPath, folderName)
			copyFolder(newPath, newCopyPath, selectedFilters)


#src = "/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/ahector/1/hw0pr3.txt"
#target = "/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/.test/hw0pr3.txt"
#copyfile(src, target)
#print pg.runTests(None,"/home/cssummer16/GraderStorage/submissions/Fall_15/CS5G/hw0/hw0pr3/.test/hw0pr3tests.txt"
#,10)

filters = ["Semester", "Class", "Assignment", "Problem", "Student"]
subFolders = getPaths(SUBMISSIONS_PATH)
selectedFilters = []
for filterName in filters:
	displayList,filteredList = pickFolder(subFolders,"Choose " + filterName)
	subFolders = getSubFolders(filteredList)
	selectedFilters.append(displayList)

#selectedFilters is in the form [[fall2016], [CS5,CS60]....]

foldersList = []
copyFolder(SUBMISSIONS_PATH,COPY_PATH,selectedFilters)

"""
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