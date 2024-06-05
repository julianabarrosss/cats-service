FROM amazoncorretto:21-alpine
WORKDIR /app
COPY backend/target/cats-0.0.1-SNAPSHOT.jar cats-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java","- jar", "cats-0.0.1-SNAPSHOT.jar"]