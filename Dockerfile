FROM openjdk:8-jdk-alpine
WORKDIR /opt/nnote
ENV PORT 8080
EXPOSE 8080
COPY target/* /opt/nnote/
ENTRYPOINT exec java $JAVA_OPTS -jar nnote-0.0.1-SNAPSHOT.jar