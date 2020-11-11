FROM gradle:3.5 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 
FROM openjdk:8
EXPOSE 8765
RUN mkdir -p /app/
COPY --from=build /home/gradle/src/build/libs/*.jar /app/zuul-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/zuul-0.0.1-SNAPSHOT.jar"]