FROM maven:4.0.0-openjdk-17 AS build
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package


FROM openjdk:17-jdk-slim
COPY --from=build /targer/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

