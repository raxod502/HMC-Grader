# coding=utf-8
import re, random, string
from datetime import datetime

from subprocess import Popen, PIPE

from app.helpers.command import Command
from os import environ

PLUGIN_NAME = "Racket (Rackunit)"

RACKET_TEST_REGEX = r"\(check-.*\?\s+\(.*\)\s+.*\s+\"([^:]+?)(?:\:.+)?\"\)"

def testFileParser(filename):
  with open(filename) as f:
    contents = f.read()

  testRegex = re.compile(RACKET_TEST_REGEX, re.M)

  testNames = []

  for test in testRegex.findall(contents):
    testNames.append(test)

  return testNames

def runTests(cmdPrefix, testFile, timeLimit):
  # Racket tests require some manipulation of the input and test files so that
  # it works nicely. We do that here
  with open(testFile, 'r') as testF:
    testText = testF.read()
    studentFileName = re.search(r'^[^;]*\(include "([^"]+)"\)',\
                                testText, re.MULTILINE).group(1)

  #Remove the #lang racket from the student file so that the import in the test
  #will work
  try:
    studentFile = open(studentFileName, 'r')
    studentFileText = studentFile.read()
    studentFile.close()

    studentFileText = re.sub(r'(#lang +racket)', r';\1\n', studentFileText)

    studentFile = open(studentFileName, 'w')
    studentFile.write(studentFileText)
    studentFile.close()
  except Exception as e:
    return {'timeout':False, 'died':True, 'rawErr': str(e)}, {}

  #Put a random string in the test file so that we can tell where the tests
  #begin.

  randline = ''.join(random.choice(string.letters + string.digits) for _ in range(10))
  testText = re.sub(r'(\(check-[^ ]+)',
                       '(displayln "' +
                        randline +
                        r'" (current-error-port))\n\1',
                        testText, count=1)

  with open(testFile, 'w') as testF:
    testF.write(testText)

  #End of manipulation of files
  #Run the tests

  testProc = Command(cmdPrefix + ['racket', testFile])

  timeout, testOut, testError = testProc.run(timeout=int(timeLimit), env=environ)

  if timeout:
    print testError
    print "Timeout reached"
    summary = {}
    summary['totalTests'] = 0
    summary['failedTests'] = 0
    summary['timeout'] = True
    summary['died'] = False
    summary['rawOut'] = ""
    summary['rawErr'] = ""

    return summary, {}

  # startTime = datetime.now()
  # testProc = Popen(cmdPrefix + ['/usr/bin/racket', testFile],\
  #                 stdout=PIPE, stderr=PIPE)
  #
  # while testProc.poll() is None:
  #   currentTime = datetime.now()
  #   delta = currentTime - startTime
  #   if delta.total_seconds() > timeLimit:
  #     testProc.kill()
  #     #Report a timeout
  #     return {'timeout':True, 'died':False}, {}

  summary = {}

  #testOut, testError = testProc.communicate()

  summary['rawOut'] = testOut
  summary['rawErr'] = testError

  if testProc.returncode == -1:
    return {'timeout':False, 'died':True, 'rawErr': testError, 'rawOut':testOut}, {}

  try:
    testResults = testError.split(randline)[1]
    # if there were no errors, result is printed to stdout
    testSummarySearch = re.search("([0-9]+) test\(s\) run", testOut)
    # Otherwise, result is printed to stderr
    if (testSummarySearch == None):
      testSummarySearch = re.search("([0-9]+) test\(s\) run", testError)

  except IndexError:
    # b. If this line was never seen, then something bad happened
    return {'timeout':False, 'died':True, 'rawErr': "Could not parse the test output:\n" + testOut + "\n\n" + testError}, {}
  else:
    failedTests = {}
    for failedCaseMatch in re.finditer('-'*20 + r'\n(.*?)\n' + '-'*20, testResults, flags=re.DOTALL):
      failedCase = failedCaseMatch.group(1)
      err = re.search(r'\nmessage: *"([^:]*):? *(.*)"\n', failedCase)
      if err:
        testname = err.group(1)
        msg = err.group(2)
        failedTests[testname] = {'hint': msg}

    summary['died'] = False
    summary['timeout'] = False
    if testSummarySearch != None:
      summary['totalTests'] = int(testSummarySearch.group(1))
    else:
      summary['totalTests'] = ""
    summary['failedTests'] = len(failedTests.keys())

    return summary, failedTests
