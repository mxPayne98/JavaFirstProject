#!/bin/bash
# configure local repository <localRepository>C:/Users/user_name/.m2/repository</localRepository> in settings.xml
cd demoproject
mvn dependency:go-offline
mvn -o clean install
read -p "Press [Enter] to exit..."