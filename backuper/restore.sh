read -p "Enter a backup datetime: " datetime
psql -v ON_ERROR_STOP=1 -U trains < /backups/$datetime/backup.sql