# Feed Database
Feed database project contains liquibase migration files for the feed API project.
## Setup
- Download liquibase from the liquibase [website](https://docs.liquibase.com/start/install/home.html) and install.
- Update the liquibase.properties file with your database credentials.
- Run command `liquibase update` in feed database folder.



Step1: 
     - go to the root of the project of database folder i.e ( feed-database > then run the command for liquibase update command)
     - make sure to create database name first then run the below command.
     - also change the db name in the feed-database  liquibase-properties file then run the below command.
     - `liquibase update`