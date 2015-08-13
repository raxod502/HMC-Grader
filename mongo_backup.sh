#!/bin/bash

MONGODUMP_PATH="/usr/bin/mongodump"
MONGO_HOST="cicero.cs.hmc.edu"
MONGO_PORT="27017"
MONGO_DATABASE="submissionsite"
ADMIN_USER="grader"
ADMIN_PASSWORD="" #put the admin password in here
SERVER_NAME="cicero"

TIMESTAMP=`date +%F-%H%M`

BACKUPS_DIR="/home/hmcgrader/mongodb-backups"
BACKUP_NAME="$SERVER_NAME-$TIMESTAMP"

S3_BUCKET_NAME="bucketname_here" #replace with your bucket name on Amazon S3
S3_BUCKET_PATH="mongodb-backups"

# Create backup, with locks to force file syncronization and lock writes
mongo admin --eval "printjson(db.fsyncLock())"
$MONGODUMP_PATH --host $MONGO_HOST:$MONGO_PORT --username $ADMIN_USER --password $ADMIN_PASSWORD --db $MONGO_DATABASE
mongo admin --eval "printjson(db.fsyncUnlock())"

mkdir -p $BACKUPS_DIR
mv dump $BACKUP_NAME
tar -zcvf $BACKUPS_DIR/$BACKUP_NAME.tgz $BACKUP_NAME
rm -rf $BACKUP_NAME

# Upload to S3
# s3cmd put $BACKUP_NAME.tgz
#    s3://$S3_BUCKET_NAME/$S3_BUCKET_PATH/$BACKUP_NAME.tgz