FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
FROM openjdk:8-jdk-alpine
EXPOSE 8091
RUN mkdir -p /app/
COPY --from=build /home/gradle/src/build/libs/*.jar /app/evento-0.1.jar
ENTRYPOINT ["java", "-jar", "/app/evento-0.1.jar"]