# coding=utf-8

from node import *
import re
import pexpect
from curses.ascii import ctrl
import re

from utilities import makeConfig

#Overloading the typical LOST, AUTH, and ACK to add some features for this
#system

def handle_con_lost(node, msg, clientID):
  client = node.getClient(clientID)

  if clientID == node.providesDB:
    node.providesDB = None
    node.dbInfo = None

  if clientID == node.providesFS:
    node.providesFS = None
    node.fsInfo = None

  if clientID == node.providesQ:
    node.providesQ = None
    node.qInfo = None

  del node.clients[clientID]

  checkUnready(node)

#Established node recieves auth response from connecting node
def handle_auth_response(node, msg, clientID):
  client = node.getClient(clientID)
  if node.authCheck(msg):
    client.accepted = True
    out = {}
    out['listeningAddr'] = node.listeningAddr
    #Notify the new node if you provide any services
    out['providesDB'] = node.providesDB == -1
    out['providesFS'] = node.providesFS == -1
    out['providesQ']  = node.providesQ  == -1
    client.sendMsg(Node.CON_ACK, out)

#If someone we connected to provides something register that and check if we
#are ready
def handle_con_ack(node, msg, clientID):
  client = node.getClient(clientID)
  client.accepted = True
  client.listeningAddr = msg['listeningAddr']
  #Fill out our table of who provides what
  if msg['providesDB']:
    node.providesDB = clientID

  if msg['providesFS']:
    node.providesFS = clientID

  if msg['providesQ']:
    node.providesQ = clientID

  client.sendMsg(Node.CON_ACK_RESP, node.listeningAddr)
  checkReady(node)


#For handling: initialize_request
def handle_initialize_request(node, msg, clientID):
  client = node.getClient(clientID)
  #For "Security"
  if not client.accepted:
    return

  #If this client is gone we simply ignore the request
  if client == None:
      return

  print "Creating client list"
  clients = [x.listeningAddr for x in node.clients.values() if not x == client]

  print "Sending client message"
  client.sendMsg(ManageNode.INITIALIZE_RESPONSE, clients)

def handle_initialize_response(node, msg, clientID):
  #If we are initialized already just ignore extra messages s
  if node.initialized:
      return

  node.initialized = True

  #We should be given a list of all of the nodes in the network
  #We then connect to all of these nodes
  for client in msg:
    newClientNum = node.getClientNum()
    node.queue.put((Node.CONNECT, client, newClientNum))

#PROVIDES_MSG: If we get a provides message add that provider and
#check if we are ready
def handle_provides_msg(node, msg, clientID):
  client = node.getClient(clientID)

  if msg == "DB":
    node.providesDB = clientID
  elif msg == "FS":
    node.providesFS = clientID
  elif msg == "Q":
    node.providesQ = clientID

  checkReady(node)


#INFO_REQ
def handle_info_request(node, msg, clientID):
  client = node.getClient(clientID)

  #For security only let accepted clients connect
  if not client.accepted:
    return

  #Handle the message request but only if we are the provider of that service
  if msg['req'] == "DB" and node.providesDB == -1:
    client.sendMsg(ManageNode.INFO_RESPONSE, ["DB", node.dbInfo])
  elif msg['req'] == "FS" and node.providesFS == -1:
    client.sendMsg(ManageNode.INFO_RESPONSE, ["FS", node.fsInfo])
  elif msg['req'] == "Q" and node.providesQ == -1:
    client.sendMsg(ManageNode.INFO_RESPONSE, ["Q", node.qInfo])


def handle_info_response(node, msg, clientID):
  client = node.getClient(clientID)

  #For security only let accepted clients connect
  if not client.accepted:
    return

  if msg[0] == "DB":
    node.dbInfo = msg[1]
  elif msg[0] == "FS":
    node.fsInfo = msg[1]
  elif msg[0] == "Q":
    node.qInfo = msg[1]

  checkReady(node)

def handle_mount_event(node, msg, clientID):
  #If we got a mount then check to see if we can startup
  #otherwise check if we have to spool down
  if msg == True:
    checkReady(node)
  else:
    checkUnready(node)

def handle_self_check(node, msg, clientID):
  checkUnready(node)
  checkReady(node)

#Check if we are ready
#REady means that we have all provides and
def checkReady(node):
  #If we are missing a provide then don't do anything
  if node.providesDB == None or \
     node.providesFS == None or \
     node.providesQ  == None:
    return

  #Get the info we need to know how to connect
  if node.dbInfo == None:
    node.sendClientMessage(node.providesDB, ManageNode.INFO_REQUEST, {'req': "DB"})
    return

  if node.fsInfo == None:
    node.sendClientMessage(node.providesFS, ManageNode.INFO_REQUEST, {'req': "FS"})
    return

  if node.qInfo == None:
    node.sendClientMessage(node.providesQ, ManageNode.INFO_REQUEST, {'req': "Q"})

  if node.providesFlask or node.providesCelery:
    #Once we have all the info make sure that we have a FSWatching client
    if node.FSWatcher == None:
      #If we aren't watching the mount point watch it now
      num = node.getClientNum()
      node.clients[num] = MountClient.spawn(node.mntPoint, node.queue, num, 0.1)
      node.FSWatcher = num

    client = node.getClient(node.FSWatcher)

    #Make sure the filesystem is mounted otherwise we wait for a mount event
    if not client.mounted:
      client.sendMsg(ManageNode.FS_MOUNT, (node.fsInfo, node.getClient(node.providesFS)))
      return

  if node.providesFlask or node.providesCelery:
    with open('config.py', 'w') as f:
      f.write( makeConfig(node) )

  if node.providesFlask:
    setupFlask(node)

def checkUnready(node):
  if node.FSWatcher != None:
    fswatch = node.getClient(node.FSWatcher)

    if not fswatch.mounted:
      if node.providesFlask:
          shutdownFlask(node)

      if node.providesCelery:
          shutdownCelery(node)

  if node.providesDB == None or \
     node.providesFS == None or \
     node.providesQ  == None:

    if node.providesFlask:
       shutdownFlask(node)

    if node.providesCelery:
        shutdownCelery(node)


#Functions for putting up and taking down
def setupFlask(node):
  #only start flask if it isn't already started
  if not node.flaskUp:
    if node.flaskScreen == None:
      screen = pexpect.spawn('screen -S flask')
      #Move to the right folder
      screen.sendline("cd " + os.getcwd())
      #exit the screen to get its name
      screen.sendline(ctrl('a')+'d')
      screen.expect("\[detached from (.*)\]")
      match = re.match("\[detached from (.*)\]", screen.after)
      node.flaskScreen = match.group(1)

    if node.flowerScreen == None:
      screen = pexpect.spawn('screen -S flower')
      #Move to the right folder
      screen.sendline("cd " + os.getcwd())
      #exit the screen to get its name
      screen.sendline(ctrl('a')+'d')
      screen.expect("\[detached from (.*)\]")
      match = re.match("\[detached from (.*)\]", screen.after)
      node.flowerScreen = match.group(1)

    #now that we have the screens up connect to them and do our business
    #we use -x to force reconnect even if someone else has connected externally
    screen = pexpect.spawn('screen -x ' + node.flaskScreen)
    screen.sendline('./graderpython/bin/gunicorn -w 4 -k gevent -b 0.0.0.0:%d app:app'%(node.flaskPort))
    screen.sendline(ctrl('a')+'d')

    screen = pexpect.spawn('screen -x ' + node.flowerScreen)
    screen.sendline('./graderpython/bin/celery flower --port=%d -A app:celery'%(node.flaskPort+1))
    screen.sendline(ctrl('a')+'d')

    #Mark that flask is up
    node.flaskUp = True


def shutdownFlask(node):
  if node.flaskUp:
    if node.flaskScreen:
      screen = pexpect.spawn('screen -x ' + node.flaskScreen)
      screen.sendline(ctrl('c'))
      screen.sendline(ctrl('a')+'d')

    if node.flowerScreen:
      screen = pexpect.spawn('screen -x ' + node.flowerScreen)
      screen.sendline(ctrl('c'))
      screen.sendline(ctrl('a')+'d')

    node.flaskUp = False

def setupCelery(node):
  if not node.celeryUp:
    if node.celeryScreen == None:
      screen = pexpect.spawn('screen -S celery')
      #Move to the right folder
      screen.sendline("cd " + os.getcwd())
      #exit the screen to get its name
      screen.sendline(ctrl('a')+'d')
      screen.expect("\[detached from (.*)\]")
      match = re.match("\[detached from (.*)\]", screen.after)
      node.celeryScreen = match.group(1)

    screen = pexpect.spawn('screen -x ' + node.celeryScreen)
    screen.sendline('./graderpython/bin/celery worker -A app:celery')
    screen.sendline(ctrl('a')+'d')
    node.celeryUp = True


def shutdownCelery(node):
  screen = pexpect.spawn('screen -x ' + node.celeryScreen)
  screen.sendline(ctrl('c'))
  screen.sendline(ctrl('a')+'d')


class ManageNode(Node):
  INITIALIZE_REQUEST      = "init_req"
  INITIALIZE_RESPONSE     = "init_resp"
  PROVIDES_MSG            = "provides"
  INFO_REQUEST            = "info_req"
  INFO_RESPONSE           = "info_resp"

  FS_MOUNT_EVENT          = "filesystem_mount_event"
  FS_MOUNT                = "filesystem_mount"

  SELF_CHECK              = "self_check"

  def __init__(self, host, port):
      Node.__init__(self, host, port, True)

      #Authentication information
      self.clusterName = None
      self.clusterKey = None
      self.authFunc = lambda: [self.clusterName, self.clusterKey]
      self.authCheck = lambda x: x == self.authFunc()

      #Has this node recieved an initialization response
      self.initialized = False

      #ID's of clients who provide these services
      #If this node provides that service the value is -1
      #If no node provides the service the value is None
      self.providesDB = None
      self.providesFS = None
      self.providesQ  = None
      self.FSWatcher = None

      #Info dictionaries for storing useful data
      self.dbInfo = None
      self.fsInfo = None
      self.qInfo  = None

      #Client side information
      self.publicKey = None

      #Front-end information
      self.mntPoint = None
      self.providesFlask = False
      self.providesCelery   = False

      #Names of the screens we have created
      self.flaskScreen = None
      self.flowerScreen = None
      self.celeryScreen = None

      self.flaskPort = 5050

      #Status of flask and celery
      self.flaskUp = False
      self.celeryUp = False

      #Set up the dispatch table
      self.dispatch[Node.CON_LOST] = handle_con_lost
      self.dispatch[Node.AUTH_RESP] = handle_auth_response
      self.dispatch[Node.CON_ACK]  = handle_con_ack
      self.dispatch[ManageNode.INITIALIZE_REQUEST] = handle_initialize_request
      self.dispatch[ManageNode.INITIALIZE_RESPONSE] = handle_initialize_response
      self.dispatch[ManageNode.PROVIDES_MSG] = handle_provides_msg
      self.dispatch[ManageNode.INFO_REQUEST] = handle_info_request
      self.dispatch[ManageNode.INFO_RESPONSE] = handle_info_response
      self.dispatch[ManageNode.FS_MOUNT_EVENT] = handle_mount_event
      self.dispatch[ManageNode.SELF_CHECK] = handle_self_check

  def getDBIP(self):
    client = self.getClient(self.providesDB)
    return client.listeningAddr()[0]

  def getQIP(self):
    client = self.getClient(self.providesQ)
    return client.listeningAddr()[0]

  def selfCheck(self):
    self.localMessage(ManageNode.SELF_CHECK, None)

class MountClient(Client):
  def __init__(self, mntPoint, queue, id, stopPoll=0.5):
    Client.__init__(self, queue, id, stopPoll)
    self.mntPoint = mntPoint
    self.mntTried = False
    self.mounted = self.checkMounted()

  def checkMounted(self):
    with open('/proc/mounts', 'r') as mounts:
      contents = mounts.read()

    if re.search(self.mntPoint, contents):
      return True
    else:
      return False

  def run(self):
    while self.running:
      iready, oready, eready = select.select([self.msgQueue._reader], [],[], self.stopPoll)

      for s in iready:
        self.putMsg(self.msgQueue.get())

      #Check for changes to /proc/mounts
      mountStatus = self.checkMounted()
      if (self.mounted != mountStatus) or (self.mounted == False and self.mntTrued):
        #If the mount status changed notify the host node
        self.mounted = mountStatus
        self.queue.put((ManageNode.FS_MOUNT_EVENT, self.mounted))
        pass

  def putMsg(self, msg):
    if msg[0] == ManageNode.FS_MOUNT:
      fsinfo, fsclient = msg[1]
      #Mount the drive
      pexpect.run("sshfs %s@%s:%s %s" % (fsinfo['user'], fsclient.listeningAddr[0], fsinfo['path'], self.mntPoint))
      self.mntTried = True
