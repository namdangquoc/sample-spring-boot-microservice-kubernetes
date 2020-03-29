FROM openjdk:8-jdk-alpine
WORKDIR /opt/nnote
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/nnote/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar