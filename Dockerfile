FROM maven As build
COPY . .

RUN mvn clean package

FROM openjdk:17.0.1-jdk-slim

COPY --from=build /app/apiAzure/target/lib /app/apiAzure/lib

WORKDIR /app/apiAzure

COPY --from=build /app/apiAzure/target/apiAzure-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]