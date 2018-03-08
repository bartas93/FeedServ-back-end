# FeedServ-back-end
Spring boot 1.5.8 app

To run this app:
1. Create database in MySql named feedserv (port 3306)
2.Add arguments in run configuration:
        -Dspring.profiles.active=mysql
        -Dmysql.user=x
        -Dmysql.passwd=y
        
        Where x and y are username and password of your MySql account
