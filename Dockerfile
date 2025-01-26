FROM openjdk:17-jdk-alpine
COPY target/market-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]