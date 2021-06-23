/****************************************************************
* Update the password for the root user (only necessary for Mac)
*****************************************************************/

-- this works with MySQL 5.5 and earlier
-- UPDATE mysql.user
-- SET Password=PASSWORD("sesame")
-- WHERE User='root' AND Host='localhost';

-- this works with MySQL 5.6 and later
SET PASSWORD FOR 'root'@'localhost' = 'sesame';
