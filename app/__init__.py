# -*- coding: utf-8 -*-
import os, sys

# Don't warn about deprecated libraries. This is obviously a
# *horrible* hack, since we should really just update the libraries.
# Unfortunately, there are more pressing problems...
import warnings
try:
    from flask.exthook import ExtDeprecationWarning
    warnings.simplefilter("ignore", ExtDeprecationWarning)
except ImportError:
    pass

from flask import Flask, g
from flask.ext.login import LoginManager, current_user
from flask.ext.mongoengine import MongoEngine
from flask.ext.bootstrap import Bootstrap
from flask.ext.markdown import Markdown
from raven.contrib.flask import Sentry
#import for celery task manager
from helpers.celeryconfig import make_celery

from markdown.extensions.attr_list import AttrListExtension
import bleach, re

#define a custom version of flask where template errors are ignored

app = Flask(__name__)
sentry = Sentry(app, dsn='https://2ea1b692a6dd4a8a88b1d36dc24d58c8:d8818bcaa2da47a69caaf6f9d19702e6@sentry.io/97156')#move dsn to config.py
#Load the configuration file config.py
app.config.from_object('config')

#Load default bootstrap templates
Bootstrap(app)

#Initialize the login system
loginManager = LoginManager()
loginManager.init_app(app)
loginManager.login_view = 'login' #Set the default view for logging in

#Initialize the database connection
db = MongoEngine(app)

#Initialize the markdown engine
markdown = Markdown(app)
markdown.register_extension(AttrListExtension)

#Initialize the celery object
celery = make_celery(app)

#Before each request we should store our current user (provided by flask-login)
#in the global object g (which is accessable inside templates)
@app.before_request
def beforeRequest():
  g.user = current_user

#Add the custom converters we have made here
from app.helpers.converters import BoolConverter, TimeConverter

app.url_map.converters['bool'] = BoolConverter
app.url_map.converters['time'] = TimeConverter

#We pre imort all the models because they have a required import order.
#By doing this here we remove that requirement in other files which makes
#extending the code easier.
from structures.models.gradebook import *
from structures.models.course import *
from structures.models.user import *
from structures.models.stats import *
from structures.models.pages import *


#Set up a function that can be used in jinja
def activeCourses():
  return Course.objects.filter(isActive=True)

#Makes list of tuples
#(Depth, isDirectory, name, path)
def walkFileTree(filepath):
  from os import listdir
  from os.path import isfile, isdir, join
  def increaseDepth(prevFile):
    def f(tup):
      return (tup[0]+1, tup[1], tup[2], join(prevFile,tup[3]))
    return f

  out = []
  for f in os.listdir(filepath):
    if isfile(join(filepath, f)):
      out.append((0, False, f, f))
    else:
      out.append((0, True, f, f))
      out += map(increaseDepth(f), walkFileTree(join(filepath, f)))

  return out



#Add globals to the templates
app.jinja_env.globals.update(activeCourses=activeCourses)
app.jinja_env.globals.update(walkFileTree=walkFileTree)

#Set up allowed HTML tags in markdown
bleach.ALLOWED_TAGS += ['pre', 'font']
bleach.ALLOWED_ATTRIBUTES[u'font'] = [u'color']

def cleanHTML(html):
  return bleach.clean(html)

def formatScore(score):
  return "%.2f" % (score)

def dedecimal(d):
  out = {}
  for k,v in d.iteritems():
    out[k] = str(v)
  return out

def cleanID(ID):
  ID = re.sub('\s', '_', ID)
  ID = re.sub('\W', '', ID)
  return ID

#Add the bleach filter
app.jinja_env.filters['bleach'] = cleanHTML
app.jinja_env.filters['formatScore'] = formatScore
app.jinja_env.filters['dedecimal'] = dedecimal
app.jinja_env.filters['cleanID'] = cleanID

#We import all of the various modules in userViews. These modules contain functions
#which generate URL->enpoint bindings which allows the pages to be rendered or
#allows redirects and AJAX calls to be executed
from userViews.common import *
from userViews.admin import *
from userViews.instructor import *
from userViews.student import *
from userViews.grutor import *
