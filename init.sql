CREATE DATABASE IF NOT EXISTS mydatabase;
GRANT ALL PRIVILEGES ON mydatabase.* TO 'movie'@'%' IDENTIFIED BY 'movie';
FLUSH PRIVILEGES;