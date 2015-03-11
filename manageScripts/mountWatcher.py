# coding=utf-8
#/usr/bin/python

import sys, subprocess, time, re

def checkMounted(mntPoint):
  '''
  Reads /proc/mounts to see if mntPoint is listed as mounted
  '''
  with open('/proc/mounts', 'r') as mounts:
    if re.search(mntPoint, mounts.read()):
      return True
    else:
      return False

def killScreen(screenName):
  subprocess.call(["screen", "-X", "-S", screenName, "kill"])

if __name__ == "__main__":
  if len(sys.argv) < 3:
    print """
Usage:
  mountWatcher.py <mount Point> <screens to kill ...>
"""
  #Argument one is our mount point
  mntPoint = sys.argv[1]
  #Arguments 2-n are our screens
  screenNames = sys.argv[2:]

  if not checkMounted(mntPoint):
    sys.exit("Directory is not currently mounted")

  while True:
    if not checkMounted(mntPoint):
      for screen in screenNames:
        killScreen(screen)
    time.sleep(1)
