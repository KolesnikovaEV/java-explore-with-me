FROM amazoncorretto:11-alpine-jdk
COPY target/stats-client-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]