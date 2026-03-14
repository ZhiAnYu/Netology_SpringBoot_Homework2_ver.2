FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
EXPOSE 8080
ADD target/RestHomework2_my-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
