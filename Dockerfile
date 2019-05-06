FROM openjdk:8-jre-alpine
COPY alpn-boot-8.1.12.v20180117.jar /alpn-boot-8.1.12.v20180117.jar
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Xbootclasspath/p:/alpn-boot-8.1.12.v20180117.jar" ,"-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]




