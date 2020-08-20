#!/bin/bash
echo "Enter phase name:"
read PHASENAME
cd demoproject
mvn help:describe -Dcmd=$PHASENAME
read -p "Press [Enter] to exit..."