#!/bin/sh
set +v echo off
# Con  se establecen comentarios
#set se definen variables
export workspace=/Users/eduardofranco/Desktop/MIW/workspace_IWVG/maven2
#Las variables de entorno se pueden configurar directamente en Windows cuando se tienen los permisos necesarios
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home
export M2_HOME=/Users/eduardofranco/Desktop/MIW/apache-maven-3.3.9
# %var% se accede a una variable
export PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin
#echo saca por pantalla un mensaje
echo -----------------------------------------
echo  MIW
echo -----------------------------------------
echo .
echo Workspace --- $workspace
echo JAVA_HOME --- $JAVA_HOME
echo M2_HOME   --- $M2_HOME
echo PATH   --- $PATH
echo .
cd $workspace
echo ============ mvn clean test =======================================================
echo .
# Se ejecuta un comando maven
mvn clean test -Denvironment.type=develop
mvn package -Denvironment.type=preproduction
echo .
#Se queda la consola abierta para realizar comandos en línea