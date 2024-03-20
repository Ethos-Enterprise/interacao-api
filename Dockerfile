FROM openjdk:17
WORKDIR /app
COPY target/interacao-app.jar .
CMD ["java", "-jar", "interacao-app.jar"]