import os
from shutil import copy

SUBMISSIONS_PATH = os.path.join(os.environ['HOME'],"GraderStorage","submissions","Fall_15", "CS60")
COPY_PATH = os.path.join(os.environ['HOME'],"jdallego")
FILTER = "jdallego" 
matchingPaths = []
count = 0
def filterFunction(entry):
  return (FILTER in entry) & ("rawTestOutput" not in entry)

def getPaths(path):
  """wrapper for os.listdir to remove hidden files and turn folder names into full paths"""
  folders = os.listdir(path)
  paths = []
  for folder in folders:
    if not folder.startswith('.'):
      pathName = os.path.join(path,folder)
      paths.append(pathName)
  return paths

def getLeaves(path):
  subPaths = getPaths(path)
  for subPath in subPaths:
    if os.path.isfile(subPath):
      if filterFunction(subPath):
        matchingPaths.append(subPath)
        print subPath
    elif os.path.isdir(subPath):
      getLeaves(subPath)

getLeaves(SUBMISSIONS_PATH)
for path in matchingPaths:
  copy(path,COPY_PATH)



