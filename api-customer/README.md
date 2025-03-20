# 🏛️ Arquitectura Hexagonal con RabbitMQ en Spring Boot

## 📌 Descripción
Este proyecto implementa una **arquitectura hexagonal** utilizando **Spring Boot**, **RabbitMQ** para mensajería asíncrona y **MapStruct (versión 1.6.3)** para la conversión de DTOs y entidades. La estructura sigue **buenas prácticas** como separación de capas, manejo de excepciones y abstracción de infraestructura.

---

## 📂 Estructura del Proyecto

📂 src/main/java/com/mcarpio/bank
│── 📂 application
│   ├── 📂 port/in        → Interfaces de casos de uso
│   ├── 📂 port/out       → Interfaces para persistencia y mensajería
│── 📂 domain
│   ├── 📂 pojos             → Entidades de dominio
│── 📂 infrastructure
│   ├── 📂 input
│   │   ├── 📂 api           → Controladores REST
│   │   ├── 📂 dto           → DTOs para request/response
│   │   ├── 📂 mapper        → Mappers entre DTOs y entidades
│   ├── 📂 output
│   │   ├── 📂 adapter       → Implementaciones de repositorios y seguridad
│   │   ├── 📂 config        → Configuración de seguridad y mensajería
│   │   ├── 📂 entity        → Entidades JPA
│   │   ├── 📂 repository    → Interfaces JPA
│   │   ├── 📂 messaging     → RabbitMQ Publisher & Listener
│   ├── 📂 exception         → Gestión centralizada de excepciones
│── 📜 BankClientApplication.java  → Clase principa

---

### 1️⃣ **Dominio (`domain`)**
📌 Contiene las entidades del negocio:
- `model/Customer.java` → Representación del cliente en el dominio.
- `model/Person.java` → Representación de una persona.

### 2️⃣ **Aplicación (`application`)**
📌 Contiene la lógica de negocio y los casos de uso:
- **Configuración**:
  - `config/RabbitConfig.java` → Configuración de RabbitMQ.
  - `config/RabbitProperties.java` → Propiedades de conexión.
- **Excepciones**:
  - `exception/ConflictException.java` → Excepción para conflictos.
  - `exception/EntityNotFoundException.java` → Excepción para entidades no encontradas.
  - `exception/ErrorResponse.java` → Estructura de respuesta de error.
- **Casos de Uso** (`port/input`):
  - `CreateCustomerUseCase.java`
  - `DeleteCustomerUseCase.java`
  - `FindAllCustomerUseCase.java`
  - `GetCustomerByIdUseCase.java`
  - `UpdateCustomerUseCase.java`
- **Puertos de salida** (`port/output`):
  - `ICustomerRepository.java` → Puerto para persistencia.
  - `IPasswordEncoder.java` → Puerto para codificación de contraseñas.
  - `IRabbitListener.java` → Puerto para mensajería.

### 3️⃣ **Infraestructura (`infrastructure`)**

#### 📥 Entrada (`input`)
- `controller/CustomerController.java` → Exposición de endpoints.
- **DTOs** (`dto/`) → Modelos de entrada y salida:
  - `CustomerRequestDTO.java`
  - `CustomerResponseDTO.java`
- **Manejo de errores** (`exception/`):
  - `ErrorResponse.java`
  - `GlobalErrorHandler.java`
- `handler/CustomerHandler.java` → Lógica de procesamiento de peticiones.
- `mapper/CustomerDTOMapper.java` → Mapeo de DTOs con **MapStruct 1.6.3**.
- `messagebroker/BusListener.java` → Listener de RabbitMQ.

#### 📤 Salida (`output`)
- **Adaptadores** (`adapter/`):
  - `ImplCustomerRepository.java` → Implementación del repositorio.
  - `ImplPasswordEncoder.java` → Implementación de codificación de contraseñas.
- **Configuración** (`config/`):
  - `SecurityConfig.java` → Configuración de seguridad.
- **Entidades** (`entity/`):
  - `CustomerEntity.java` → Entidad JPA.
  - `PersonEntity.java` → Entidad JPA.
- **Mapeo** (`mapper/`):
  - `CustomerMapper.java` → **Mapeo de entidades con MapStruct 1.6.3**.
- **Repositorio** (`repository/`):
  - `IOutPutCustomerRepository.java` → Repositorio de persistencia.

### 4️⃣ **Mensajería con RabbitMQ (`messagebroker`)**
📌 Se encarga de la integración con RabbitMQ:
- `BusListener.java` → Consumidor de mensajes de RabbitMQ.
- `RabbitConfig.java` → Configuración de colas y exchanges.

---

## 📌 📊 Diagrama de la Arquitectura
```txt
                       +-----------------------+
                       |    🔹 Controller      |
                       +----------+------------+
                                  |
                                  ▼
                       +-----------------------+
                       |    🔹 Handlers        |
                       +----------+------------+
                                  |
                                  ▼
               +---------------------------------------+
               |         🔹 Casos de Uso              |
               |  (application/port/input)           |
               +---------------------------------------+
                                  |
                                  ▼
               +---------------------------------------+
               |         🔹 Repositorios              |
               |  (application/port/output)          |
               +---------------------------------------+
                                  |
                                  ▼
               +---------------------------------------+
               |         🔹 Persistencia              |
               |  (infrastructure/output)            |
               +---------------------------------------+
                                  |
                                  ▼
               +---------------------------------------+
               |         🔹 RabbitMQ                   |
               |  (messagebroker)                     |
               +---------------------------------------+

## 🚀 Tecnologías Utilizadas  
Este proyecto ha sido desarrollado utilizando las siguientes tecnologías:  

- **Java 21**: Lenguaje de programación principal.  
- **Spring Boot 3**: Framework para el desarrollo de aplicaciones empresariales.  
- **Spring Web**: Para la creación de APIs REST.  
- **Spring Data JPA**: Para la gestión de la persistencia con bases de datos relacionales.  
- **Spring Security**: Para la autenticación y autorización.  
- **MapStruct 1.6.3**: Librería para el mapeo automático entre entidades y DTOs.  
- **RabbitMQ**: Sistema de mensajería asíncrona para la comunicación entre servicios.  
- **PostgreSQL**: Base de datos relacional utilizada en el proyecto.  
- **Docker**: Para la creación de contenedores y despliegue de la aplicación.  
- **Docker Compose**: Para la gestión de múltiples contenedores, incluyendo la aplicación, RabbitMQ y PostgreSQL.  

---

## 🐳 Ejecución con Docker Compose  
Para ejecutar la aplicación junto con RabbitMQ y PostgreSQL, sigue estos pasos:  

1. **Asegúrate de tener Docker y Docker Compose instalados** en tu sistema.  
2. **Ubícate en la raíz del proyecto**, donde se encuentra el archivo `docker-compose.yml`.  
3. **Ejecuta el siguiente comando** para levantar los servicios:  

```sh
docker-compose up -d
