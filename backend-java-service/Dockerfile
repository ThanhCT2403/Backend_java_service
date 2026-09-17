FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} backend-java-service.jar
ENTRYPOINT ["java", "-jar", "backend-java-service.jar"]
EXPOSE 8080