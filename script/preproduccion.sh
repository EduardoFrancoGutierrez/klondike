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
echo ". (C) MIW"
echo -----------------------------------------
echo .
echo Workspace --- $workspace
echo .
echo .

cd $workspace
# -ff, --fail-fast. Stop at first failure in reactorized builds. Línea de comentario
echo "============ mvn -ff clean test (profile: develop) ========================================================================="
echo .
mvn -ff clean test 
if [ $? -gt 0 ] ; then
    echo .
    echo .
    echo .
    echo "########  ERRORES..."
else
    echo .
    echo ":: -Dmaven.test.skip=true. To skip running the tests for a particular project"
    echo "============ call mvn -Dmaven.test.skip=true install -Denvironment.type=preproduction (profile: preproduction) ================"
    echo .
    mvn -Dmaven.test.skip=true install -Denvironment.type=preproduction
    exit    
fi