FROM maven:3.9.9 AS build
RUN mkdir /construir
WORKDIR /construir
COPY . /construir
RUN mvn clean package install

FROM openjdk:21-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY --from=build /construir/target/api-customer.jar /app/api-customer.jar
EXPOSE 9595
ENV DEFAULT_OPTIONS="-Duser.timezone=America/Guayaquil -Djava.net.preferIPv4Stack=true -Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS="-Xms512m -Xmx896m"
ENTRYPOINT java ${DEFAULT_OPTIONS} ${JAVA_OPTS} -jar /app/api-customer.jar