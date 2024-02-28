FROM maven As build
COPY . .

RUN mvn clean package

FROM openjdk:17.0.1-jdk-slim



COPY --from=build /target/apiAzure-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]