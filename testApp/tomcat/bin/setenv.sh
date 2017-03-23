#!/bin/bash


# Для загрузки свойств из conf
CLASSPATH=$CATALINA_HOME/conf

#  -Djava.security.egd=file:/dev/./urandom - очень выжный параметр. При старте tomcat что-то рандомогенерирует.
# Если стартануть несколько томкатов без этого параметра - они начнут стукаться лбами и медленно стартовать.
GENERAL_OPTS="-Xms512m -Xmx1024m  -Duser.timezone=UTC -Djava.security.egd=file:/dev/./urandom "

DEBUG_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

if [ -z $CATALINA_OPTS ]; 
then
  CATALINA_OPTS=" -Dtype=testApp $GENERAL_OPTS " #$DEBUG_OPTS
fi

