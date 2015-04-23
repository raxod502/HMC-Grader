groody-grader
=============

To run this site you must create a python virtual env for testing. This has to have the following packages installed:

 * flask
 * flask-script
 * flask-bootstrap
 * flask-login
 * flask-markdown
 * mongoengine
 * flask-mongoengine
 * WTForms
 * python-dateutil
 * pygments
 * celery
 * flower
 * psutil
 * gunicorn
 * gevent

The site can then be run with the command:

`<virtualenv>/bin/python run.py`

If you use SSHFS it is recommended to use the following command to mount your remote drive

`sshfs -o reconnect user@remotehost:/remote/path /local/path`
