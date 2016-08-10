# coding=utf-8

import os
basedir = os.path.abspath(os.path.dirname(__file__))

import socket
import fcntl
import struct

def get_ip_address(ifname):
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    return socket.inet_ntoa(fcntl.ioctl(
        s.fileno(),
        0x8915,  # SIOCGIFADDR
        struct.pack('256s', ifname[:15])
    )[20:24])

SERVER_IP = get_ip_address('eth0')  # '192.168.0.110'
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
CELERY_BROKER_URL="amqp://admin:grutorsLoveGrading@"+SERVER_IP
FLOWER_ACCESS_URL="http://127.0.0.1:5555"

#
# Settings for file storage
#
STORAGE_HOME="/home/cssummer16/GraderStorage"

STORAGE_MOUNTED=False

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