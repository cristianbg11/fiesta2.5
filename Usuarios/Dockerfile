FROM gradle:3.5 AS build
RUN gradle build --no-daemon 
FROM openjdk:8
RUN mkdir -p /app/
ADD build/libs/Usuarios-0.0.1-SNAPSHOT.jar /app/Usuarios-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/Usuarios-0.0.1-SNAPSHOT.jar"]