# coding=utf-8

import sys

from os import listdir
from os.path import abspath, join, splitext, isdir
from json import load

from app.plugins.autograder import getTestFileParsers

USAGE = """Usage:

python graderTester <pluginName> <testfolder>
"""

def findTestFile(folderPath, folderName):
  for f in listdir(folderPath):
    if splitext(f)[0] == folderName:
      return f
  return None

def printSet(s):
  for i in s:
    print i

def doParseTests(folderPath, folderName, parser):
  testFile = findTestFile(folderPath, folderName)

  if testFile == None:
    print "Could not find test file in folder: %s" % (folderPath)
    return

  print "Parsing file: %s\n" % (testFile)

  foundTests = set(parser(join(folderPath, testFile)))

  #Load the test specification
  with open(join(folderPath, testFile+'.json')) as testSpec:
    spec = load(testSpec)
    expectedTests = set(spec['testNames'])

  missingTests = expectedTests - foundTests
  extraTests = foundTests - expectedTests

  if len(missingTests) > 0:
    print "Parser failed to find the following tests: "
    printSet(missingTests)
    print "\n"

  if len(extraTests) > 0:
    print "Parser found the following extra tests: "
    printSet(extraTests)
    print "\n"

  print "Parsing test Finished for file: %s\n\n" % (testFile)

if __name__ == "__main__":
  if len(sys.argv) < 3:
    print USAGE
    sys.exit(1)

  print "\n\n"

  #Get the file
  print "Getting plugin"
  fileParser = getTestFileParsers()[sys.argv[1]]
  testFolder = sys.argv[2]

  testFolder = abspath(testFolder)

  #Each test case is contained in a folder which has the name of the test file.
  #We look into each directory in turn and use the test
  #file and the testfile.json file to determine if everything is correct
  #any supplemental files can be included in these folders and will be isolated
  #from the rest of the files

  for d in listdir(testFolder):
    #Skip non dir
    if not isdir(join(testFolder, d)):
      continue

    doParseTests(join(testFolder,d), d, fileParser)
