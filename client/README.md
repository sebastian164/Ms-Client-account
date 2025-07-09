# 📜 Client Microservice - Devsu

Microservicio de gestión de clientes y personas, parte del sistema bancario Devsu. Implementado con Spring Boot y arquitectura hexagonal.

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.3.4
- Maven
- MySQL
- MapStruct
- Spring Security (JWT)
- Swagger OpenAPI
- Docker

---

## 🧱 Arquitectura

Este microservicio sigue una arquitectura hexagonal (puertos y adaptadores):

- **Dominio**
  - `model`: Entidades del dominio (`Client`, `Person`)
  - `port.in`: Casos de uso
  - `port.out`: Contratos hacia infraestructura
- **Aplicación**
  - `dto`: Objetos de transferencia
  - `mapper`: Mapeos entre DTO y modelos
  - `service`: Implementación de casos de uso
- **Infraestructura**
  - `controller`: Controladores REST
  - `persistence`: Repositorios JPA y mapeadores `Entity` ↔ `Model`
  - `security`: JWT, filtros y configuración de seguridad

---

## 🧊 Endpoints principales

> Todos los endpoints están bajo `/api/clients`

| Método | Endpoint             | Descripción                   |
|--------|----------------------|-------------------------------|
| POST   | `/`                  | Crear un nuevo cliente        |
| GET    | `/{id}`              | Obtener cliente por ID        |
| GET    | `/`                  | Obtener todos los clientes    |
| PUT    | `/{id}`              | Actualizar cliente            |
| DELETE | `/{id}`              | Eliminar cliente              |

Swagger disponible en: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧹 Configuración

### Base de datos

Se utiliza una base de datos MySQL en el entorno `dev`.

```yaml
spring:
  datasource:
    url: jdbc:mysql://srv944.hstgr.io:3306/u836450600_client
    username: u836450600_client
    password: 7Z]+F:DQd6Tc
    driver-class-name: com.mysql.cj.jdbc.Driver
```

---

## 🚀 Docker: Construcción y Ejecución

### 🧱 Construir la imagen Docker

Genera el `.jar` previamente:

```bash
mvn clean package
```

Construye la imagen Docker:

```bash
docker build -t client-ms .
```

### ▶️ Ejecutar el contenedor

```bash
docker run -p 8080:8080 client-ms
```

El microservicio es expuesto en  `http://localhost:8080`.

### 📦 Requisitos

- Tener [Docker Desktop](https://www.docker.com/products/docker-desktop/) instalado y corriendo.

