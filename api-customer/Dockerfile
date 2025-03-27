FROM maven:3.9.9 AS build
WORKDIR /construir

RUN apt-get update && apt-get install -y ca-certificates && update-ca-certificates

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY . ./
RUN mvn clean package -DskipTests && ls -l target/

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /construir/target/api-customer-1.0.jar app.jar

EXPOSE 9595

ENV DEFAULT_OPTIONS="-Duser.timezone=America/Guayaquil -Djava.net.preferIPv4Stack=true -Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS="-Xms512m -Xmx896m"

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
