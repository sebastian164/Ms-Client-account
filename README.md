# 🏦 Devsu Banking System - Monorepo

Este monorepo agrupa dos microservicios desarrollados con Spring Boot y arquitectura hexagonal, que forman parte del sistema bancario de Devsu:

- 📜 `client`: Gestión de clientes y personas.
- 📒 `account`: Gestión de cuentas bancarias y movimientos.

Cada servicio es independiente, mantiene su propia base de datos y sigue buenas prácticas de diseño limpio, seguridad y escalabilidad.

---

## 📂 Estructura del Repositorio

```
devsu-banking-system/
├── client/      # Microservicio de clientes y personas
├── account/     # Microservicio de cuentas y movimientos
└── README.md            # Este archivo
```

---

## 🧰 Stack Tecnológico

- Java 21
- Spring Boot 3.3.4
- Maven
- MySQL
- MapStruct
- Spring Security (JWT)
- Swagger OpenAPI
- Docker

---

## 🧱 Arquitectura Común

Ambos microservicios siguen el patrón de **arquitectura hexagonal** (puertos y adaptadores), distribuidos en:

- **Dominio**
  - `model`: Entidades del dominio
  - `port.in`: Casos de uso
  - `port.out`: Contratos hacia infraestructura
- **Aplicación**
  - `dto`: Objetos de transferencia
  - `mapper`: Conversión entre entidades y modelos
  - `service`: Lógica de negocio
- **Infraestructura**
  - `controller`: Endpoints REST
  - `persistence`: Repositorios JPA y mapeadores
  - `security`: Configuración de autenticación JWT (si aplica)
  - `handler`: Manejadores de excepciones

---

## 📜 Client Service

Microservicio encargado de la gestión de clientes y personas.

📍 Base URL: `/api/clients`

| Método | Endpoint   | Descripción             |
|--------|------------|-------------------------|
| POST   | `/`        | Crear un nuevo cliente  |
| GET    | `/{id}`    | Obtener cliente por ID  |
| GET    | `/`        | Listar todos            |
| PUT    | `/{id}`    | Actualizar cliente      |
| DELETE | `/{id}`    | Eliminar cliente        |

🔗 Swagger: http://localhost:8080/swagger-ui.html

---

## 📒 Account Service

Microservicio encargado de la gestión de cuentas y movimientos.

📍 Base URL: `/api/accounts` y `/api/movements`

### Cuentas

| Método | Endpoint   | Descripción               |
|--------|------------|---------------------------|
| POST   | `/`        | Crear cuenta              |
| GET    | `/{id}`    | Obtener cuenta por ID     |
| GET    | `/`        | Listar cuentas            |
| PUT    | `/{id}`    | Actualizar cuenta         |
| DELETE | `/{id}`    | Eliminar cuenta           |

### Movimientos

| Método | Endpoint   | Descripción                                   |
|--------|------------|-----------------------------------------------|
| POST   | `/`        | Crear nuevo movimiento                        |
| GET    | `/account/{accountId}` | Movimientos por cuenta             |
| GET    | `/account/{accountId}/range?from=YYYY-MM-DD&to=YYYY-MM-DD` | Movimientos por rango de fechas |

🔗 Swagger: http://localhost:8081/swagger-ui.html

---

## 🐳 Docker

### Construcción

```bash
# En cada servicio
mvn clean package
docker build -t <nombre-imagen> .
```

### Ejecución

```bash
docker run -p <puerto>:<puerto> <nombre-imagen>
```

Por ejemplo:

```bash
docker run -p 8080:8080 client-ms
docker run -p 8081:8081 account-ms
```

---

## 🗃️ Base de Datos

Cada servicio utiliza una base de datos MySQL diferente definida en sus respectivos archivos de configuración.

---

## ✅ Requisitos

- Docker Desktop
- JDK 21
- Maven 3.9+
- MySQL 8+

---

## ✍️ Autor

Este monorepo fue creado como parte de un sistema bancario modular y escalable, con foco en buenas prácticas, separación de responsabilidades y seguridad.
