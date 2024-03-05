FROM openjdk:17

ARG JAR_FILE=target/movie-0.0.1-SNAPSHOT.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]