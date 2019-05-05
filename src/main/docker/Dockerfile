FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    PUSH_SLEEP=0 \
    JAVA_OPTS="" \
    ALPN_JAR="/home/push/alpn-boot-8.1.12.v20180117.jar"

# Add a jhipster user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh push
WORKDIR /home/push

COPY alpn-boot-8.1.12.v20180117.jar /home/push

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown push:push entrypoint.sh
USER push

ENTRYPOINT ["./entrypoint.sh"]

EXPOSE 8080

ADD *.jar app.jar

