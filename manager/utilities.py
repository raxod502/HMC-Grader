# coding=utf-8
import pexpect

def checkForProgram(program):
  return len(pexpect.run("which " +program)) > 0

def getInput(msg, typecast, verify, tryLimit=5):
  tries = 0
  while tries < tryLimit:
    try:
      data = typecast(raw_input(msg))
      if not verify(data):
        tries += 1
        print "Invalid input please try again\n"
        continue
      else:
        return data
    except ValueError:
      print "Data couldn't be converted to correct type. Please try again\n"
      tries += 1
      continue

  sys.exit("Maximum number of tries exceeded exiting program")

def getYN(msg):
  return getInput(msg, str, lambda x: x in ['y','n']) == 'y'

def makeStatusMsg(mN, status):
  if status == None:
    return "Not provided"
  elif status == -1:
    return "Provided by self"
  else:
    client = mN.getClient(status)
    return "Provided by %s:%d" % (client.listeningAddr[0], client.listeningAddr[1])

def makeConfig(mN):
  return CONFIG_TEMPLATE.format(\
      dbname=mN.dbInfo['dbName'],\
      dbuser=mN.dbInfo['dbUser'],\
      dbpass=mN.dbInfo['dbPass'],\
      dbhost=mN.getDBIP(),\
      dbport=mN.dbInfo['dbPort'],\
      quser=mN.qInfo['qUser'],\
      qpass=mN.qInfo['qPass'],\
      qhost=mN.getQIP(),\
      mntpoint=mN.mntPoint)

CONFIG_TEMPLATE = """
# coding=utf-8

import os
basedir = os.path.abspath(os.path.dirname(__file__))

#
# Settings for WTForms
#
CSRF_ENABLES=True
SECRET_KEY="Grutors <3 SPAM"

#
#Mongo settings
#
MONGODB_SETTINGS = {{'DB': {dbname:r},
'username': {dbuser:r},
'password': {dbpass:r},
'host': {dbhost:r}},
'port': {dbport:r}}

DATABASE_QUERY_TIMEOUT = 0.5

#
#Celery config ssettings
#
CELERY_BROKER_URL="amqp://{quser:s}:{qpass:s}@{qhost:s}"

#
# Settings for file storage
#
STORAGE_HOME={mntpoint:r}


#
# Email settings
#

SYSTEM_EMAIL_ADDRESS = "cloud@cs.hmc.edu"

SMTP_SERVER = "knuth.cs.hmc.edu"


#
# Autograder settings
#

AUTOGRADER_PLUGIN_PATH = os.path.join(STORAGE_HOME, "plugins/autograder")
LATEWORK_PLUGIN_PATH = os.path.join(STORAGE_HOME, "plugins/latework")

GRADER_USER = None
"""
