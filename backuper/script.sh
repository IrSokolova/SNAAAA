#!/bin/sh
while [ true ]
do
    echo "Trying to backup data"
    mkdir -p backups/$(date '+%Y-%m-%dT%H:%M:%S')
    pg_dump -U trains --host=$PGHOST --file backups/$(date '+%Y-%m-%dT%H:%M:%S')/backup.sql && echo "Backup from $(date '+%Y-%m-%dT%H:%M:%S') successful!"
    sleep 10
done
