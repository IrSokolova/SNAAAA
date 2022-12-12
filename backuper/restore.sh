read -p "Enter a backup datetime: " datetime
psql -v ON_ERROR_STOP=0 -X -U trains < /backups/$datetime/backup.sql