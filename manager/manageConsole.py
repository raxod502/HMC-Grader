# coding=utf-8

from utilities import makeStatusMsg
import json

def commandLine(manageNode):
  print """
Starting interactive command line...
  """

  while True:
    cmd = raw_input("> ")
    if cmd.lower() == "stop":
      break
    elif cmd.lower() == "status":
      print """
================================================================================
= Backing System Status                                                        =
================================================================================

Database Status:     %s
DB Info: %s

File System Status:  %s
FS Info: %s

Work Queue Status:   %s
Q Info: %s

================================================================================
= Node Status                                                                  =
================================================================================

clients: %d
messages: %d

""" % (
  makeStatusMsg(manageNode, manageNode.providesDB),
  json.dumps(manageNode.dbInfo, sort_keys=True, indent=4, separators=(',', ': ')),
  makeStatusMsg(manageNode, manageNode.providesFS),
  json.dumps(manageNode.dbInfo, sort_keys=True, indent=4, separators=(',', ': ')),
  makeStatusMsg(manageNode, manageNode.providesQ),
  json.dumps(manageNode.dbInfo, sort_keys=True, indent=4, separators=(',', ': ')),
  len(manageNode.clients),
  manageNode.queue.qsize()
  )
