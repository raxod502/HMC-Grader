from app import app

from os import listdir, getcwd
from os.path import isfile, join, basename, dirname, splitext
import imp

PLUGINS = [
    "hmmmgrader",
    "java4grader",
    "jflapgrader",
    "jflapgrader_tm",
    "newjflapgrader",
    "picobotgrader",
    "prologgrader",
    "pythongrader",
    "rackunit",
    "supplemental",
]

def getTestFileParsers():
  searchList = [dirname(__file__)]
  if app.config['AUTOGRADER_PLUGIN_PATH'] != None:
    searchList.append(app.config['AUTOGRADER_PLUGIN_PATH'])
  out = {}
  for name in PLUGINS:
      moduleInfo = imp.find_module(name, searchList)
      m = imp.load_module(name, moduleInfo[0], moduleInfo[1], moduleInfo[2])
      out[m.PLUGIN_NAME] = m.testFileParser
  return out


def getTestRunners():
  searchList = [dirname(__file__)]
  if app.config['AUTOGRADER_PLUGIN_PATH'] != None:
    searchList.append(app.config['AUTOGRADER_PLUGIN_PATH'])
  out = {}
  for name in PLUGINS:
      moduleInfo = imp.find_module(name, searchList)
      m = imp.load_module(name, moduleInfo[0], moduleInfo[1], moduleInfo[2])
      out[m.PLUGIN_NAME] = m.runTests
  return out
