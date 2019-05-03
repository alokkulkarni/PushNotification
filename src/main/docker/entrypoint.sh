#!/bin/sh

echo "The application will start in ${PUSH_SLEEP}s..." && sleep ${PUSH_SLEEP}
exec java -Xbootclasspath/p:/Users/alokkulkarni/Downloads/alpn-boot-8.1.12.v20180117.jar ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.war" "$@"
