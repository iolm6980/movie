FROM openjdk:17

WORKDIR /app

COPY movie-0.0.1-SNAPSHOT.jar app.jar

RUN chmod 666 app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]