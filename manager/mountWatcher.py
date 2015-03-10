# coding=utf-8

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
  mntPoint = raw_input("What directory should be mounted?: ")
  screenName = raw_input("What screen should be shutdown?: ")

  if not checkMounted(mntPoint):
    sys.exit("Directory is not currently mounted")

  while True:
    if not checkMounted(mntPoint):
      killScreen(screenName)
    time.sleep(1)
