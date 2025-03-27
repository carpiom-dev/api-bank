# 🏦 Microservicio Bank API

## 📌 Descripción
Este microservicio gestiona la información de clientes en un sistema bancario. Implementa arquitectura hexagonal con **Spring Boot 3** y **Java 21**, utilizando **PostgreSQL** como base de datos y ejecutándose en **Docker**.

## 🚀 Tecnologías Utilizadas
- ☕ **Java 21**
- 🌱 **Spring Boot 3**
- 🏛️ **Arquitectura Hexagonal**
- 🐘 **PostgreSQL**
- 🐳 **Docker**
- 🔄 **Lombok**
- 📜 **JPA Hibernate**
- 📡 **Spring WebFlux** (para operaciones reactivas)
- 📊 **Swagger OpenAPI**
- 📨 **RabbitMQ** (Mensajería asíncrona)

## 📂 Estructura del Proyecto
```
com.mcarpio.bank
│── application
│   ├── config
│   └── ports
│       ├── in (Casos de uso)
│       │   ├── DeleteCustomerByIdUseCase
│       │   ├── FindAllCustomerUseCase
│       │   ├── FindByStatusTrueCustomerUseCase
│       │   ├── FindCustomerByIdUseCase
│       │   ├── SaveCustomerUseCase
│       │   └── UpdateCustomerUseCase
│       └── out (Interfaces y adaptadores externos)
│           ├── ICustomerRepository
│           ├── ILogBusMessageListener
│           └── IPasswordEncoder
│── domain
│   ├── exception
│   │   ├── CustomerAlreadyExistsException
│   │   ├── CustomerNotFoundException
│   │   └── ErrorResponse
│   ├── pojos
│   │   ├── CustomerPojo
│   │   ├── Log
│   │   └── PersonPojo
│── infrastructure
│   ├── in
│   │   ├── api
│   │   │   └── CustomerApi
│   │   ├── dto
│   │   │   ├── CustomerInDTO
│   │   │   ├── CustomerOutDTO
│   │   │   ├── CustomerUpdateInDto
│   │   ├── handler
│   │   │   └── CustomerHandler
│   │   ├── mapper
│   │       └── ICustomerMapperDto
│   ├── out
│   │   ├── adapter
│   │   │   ├── CustomerRepositoryImpl
│   │   │   ├── PasswordEncoderRepositoryImpl
│   │   ├── config
│   │   │   ├── OpenAPIConfig
│   │   │   ├── RabbitConfig
│   │   │   ├── RabbitProperties
│   │   │   ├── UseCaseConfig
│   │   ├── entity
│   │   │   ├── CustomerEntity
│   │   │   ├── PersonEntity
│   │   ├── mapper
│   │   │   ├── ICustomerMapper
│   │   ├── rabbitmq
│   │   ├── repository
│   │   │   ├── IJpaCustomerRepository
```

## 📌 Configuración del Microservicio

### Dockerfile
```dockerfile
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
```

### Configuración `application.yml`
```yaml
spring:
  application:
    name: api-customer

  profiles:
    active: dev

  datasource:
    url: jdbc:postgresql://localhost:5433/BankApi
    username: postgres
    password: admin

server:
  port: 9595
  servlet:
    context-path: /api/v1

springdoc:
  swagger-ui:
    enabled: true
    path: /swagger-ui.html
  api-docs:
    enabled: true
    path: /v3/api-docs
```

## 📌 Endpoints Swagger
- 📜 API Docs: [http://localhost:9595/api/v1/v3/api-docs](http://localhost:9595/api/v1/v3/api-docs)
- 📝 Swagger UI: [http://localhost:9595/api/v1/swagger-ui/index.html](http://localhost:9595/api/v1/swagger-ui/index.html)

## 🔥 Instalación y Ejecución
### 1️⃣ Prerrequisitos
Asegúrate de tener instalado:
- 🛠️ **JDK 21**
- 🐳 **Docker & Docker Compose**
- 🐘 **PostgreSQL**
- 📨 **RabbitMQ**

### 2️⃣ Clonar el repositorio
```bash
git https://github.com/carpiom-dev/api-bank.git
```

### 3️⃣ Construir y levantar servicios con Docker
```bash
docker-compose build
docker-compose up -d
```

### 4️⃣ Ejecutar la aplicación manualmente
```bash
mvn spring-boot:run
```

## 📜 Licencia
Este proyecto está bajo la licencia **MIT**. ¡Siéntete libre de contribuir! 🤝

---
🚀 Desarrollado con 💙 por Manuel Carpio

