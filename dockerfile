FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
version: '3.8'
services:
 flight-app:
 build: .
 ports:
 - "8080:8080"
 environment:
 - SPRING_PROFILES_ACTIVE=default