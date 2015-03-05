# coding=utf-8

from utilities import getInput, getYN

def runSetup(mN):
  print """
================================================================================
= Setup Support Services                                                       =
================================================================================
"""

  #Get the mounting point for the flask server
  mntPoint = getInput("Where should the remote FS get mounted? (absolute path):", str, lambda x: True)
  mN.mntPoint = mntPoint


  choice = getYN("Do you want this server to be an HTTP server? [y/n]: ")

  if choice:
    port = getInput("What port should the server listen on?: ", int, lambda x: True)
    mN.flaskPort = port
