#!/bin/bash
cd demoproject
mvn -Dmaven.repo.local=$HOME/.my/other/repository clean install
read -p "Press [Enter] to exit..."