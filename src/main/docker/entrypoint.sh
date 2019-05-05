#!/bin/sh

echo "The application will start in ${PUSH_SLEEP}s..." && sleep ${PUSH_SLEEP}
exec java -Xbootclasspath/p:${ALPN_JAR} ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.war" "$@"
