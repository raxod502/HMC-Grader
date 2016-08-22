# coding=utf-8

import os
basedir = os.path.abspath(os.path.dirname(__file__))

import socket
import fcntl
import struct
import netifaces as ni #requires installation of netifaces in the virtual environment

#get computers eth* ip address
interfaces = ni.interfaces()
eth_interface = filter(lambda item: item.startswith('eth'),interfaces)[0]
#get the IP address associated with the first eth* 
ni.ifaddresses(eth_interface)
SERVER_IP = ni.ifaddresses(eth_interface)[2][0]['addr']

import getpass
SERVERUSER = getpass.getuser()

#
# Settings for WTForms
#
# Current settings are for testing only change for production
CSRF_ENABLES=True
SECRET_KEY="Grutors <3 SPAM"

#
#Mongo settings
#
# Current settings are for testing only change for production
MONGODB_SETTINGS = {'DB': 'submissionsite',
'username': 'grader',
'password': 'grutorsLoveGrading',
'host': SERVER_IP}

DATABASE_QUERY_TIMEOUT = 0.5

#
#Celery config ssettings
#
CELERY_BROKER_URL="amqp://admin:grutorsLoveGrading@134.173.43.10"
FLOWER_ACCESS_URL="http://127.0.0.1:5555"#Errno 111 likely means that celery flower isnt started

#
# Settings for file storage
#
STORAGE_HOME="/home/"+SERVERUSER+"/GraderStorage"

STORAGE_MOUNTED=False

#
# Email settings 
#

SYSTEM_EMAIL_ADDRESS = "cloud@cs.hmc.edu"

SMTP_SERVER = "knuth.cs.hmc.edu"#now running locally email setup in accounts.py

#
# Autograder settings
#

AUTOGRADER_PLUGIN_PATH = os.path.join(STORAGE_HOME, "plugins/autograder")
LATEWORK_PLUGIN_PATH = os.path.join(STORAGE_HOME, "plugins/latework")

GRADER_USER = None