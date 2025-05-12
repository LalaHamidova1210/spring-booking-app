FROM openjdk:17-jdk-slim
COPY build/libs/spring-hotel-booking-app-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
