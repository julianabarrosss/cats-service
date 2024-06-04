FROM amazoncorretto:21-alpine

COPY target/cats-0.0.1-SNAPSHOT.jar cats-service.jar

ENTRYPOINT ["java", "-jar", "cats-service.jar"]