Back-end application for managing a restaurant.
        Spring boot 1.5.8, JWT, Spring Date, Spring Security, MySql

Architecture (Packages, entites, relationships) - implemented. 
First module - order managment - implemented.

To run this app:
1. Create database in MySql named feedserv (port 3306)
2.Add arguments in run configuration:
        -Dspring.profiles.active=mysql
        -Dmysql.user=x
        -Dmysql.passwd=y
        
        Where x and y are username and password of your MySql account
