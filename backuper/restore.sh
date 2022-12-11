read -p "Enter a backup datetime: " datetime
psql -U trains < /backups/$datetime/backup.sql