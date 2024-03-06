FROM openjdk:17

WORKDIR /app

COPY movie-0.0.1-SNAPSHOT.jar app.jar

# 어플리케이션 파일에 대한 권한 설정 (예: 모든 사용자에 대한 읽기 권한)
RUN chmod 666 app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]