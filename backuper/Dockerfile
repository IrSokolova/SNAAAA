FROM ubuntu:latest
FROM postgres

# RUN apt-get update && apt-get -y install cron

# COPY psql-backup /etc/cron.d/psql-backup
COPY script.sh script.sh
COPY restore.sh restore.sh
 
# RUN chmod 0644 /etc/cron.d/psql-backup
RUN chmod 777 script.sh

# RUN crontab /etc/cron.d/psql-backup
 
# RUN touch /var/log/cron.log
CMD sh script.sh
