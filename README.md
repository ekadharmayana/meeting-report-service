# Meeting Report Service

Spring Boot backend service for managing meetings and (optionally) attendance data.  
This is a **portfolio project** with a focus on **Java backend development**, **clean architecture**, and **production-like REST APIs**.

## ✨ Features
- REST API to create and retrieve meetings
- Persistence with **MySQL** and **JPA (Hibernate)**
- Database schema migrations using **Flyway**
- DTO-based API design (no entity leaks)
- Centralized error handling with consistent JSON error responses
- **Docker Compose** for local development
- **OpenAPI / Swagger UI** for API documentation
- **Paginated and filterable meetings endpoint**
  (`page`, `size`, `from`, `to`, `organizerEmail`)
---

## 🛠 Tech Stack
- Java 21
- Spring Boot 3
- Spring Web, Spring Data JPA, Spring Security
- MySQL
- Flyway
- Docker & Docker Compose
- Maven
- Swagger / OpenAPI
---

## 🚀 Start your project locally

### 1. Prerequisites
- Java 21 or higher
- Docker & Docker Compose
- Maven (or Maven Wrapper)
---

### 2. Clone the repository
```
git clone https://github.com/ekadharmayana/meeting-report-service.git
cd meeting-report-service
```
---

### 3. Setting Environment Variables
This project uses **environment variables** for database configuration.

**Required Variables**
```
DB_URL
DB_USER
DB_PASSWORD
```

**🪟 Windows (PowerShell)**
```
$env:DB_URL="jdbc:mysql://localhost:3306/meetingdb"
$env:DB_USER="meetinguser"
$env:DB_PASSWORD="meetingpass"
```

**🐧 Linux / macOS**
```
export DB_URL=jdbc:mysql://localhost:3306/meetingdb
export DB_USER=meetinguser
export DB_PASSWORD=meetingpass
```
---

### 4. Start MySQL using Docker Compose
```
docker compose up -d
```

### 5. Run Application
```
./mvnw spring-boot:run
```
The application then runs under: `http://localhost:8080`

---
### 📖 API Dokumentation (Swagger)
After launch, you can reach us at: `http://localhost:8080/swagger-ui/index.html`

---
### 📌 Example API Requests
**Create a meeting**

**POST**`/meeting`
```
{
  "title": "Daily Standup",
  "organizerEmail": "lead@example.com",
  "startTime": "2026-02-05T09:00:00",
  "endTime": "2026-02-05T09:15:00"
}
```
**Retrieve a meeting**

**GET**`/meeting/{id}`

**List Meetings (pagignation & filters)**

**GET** `/meetings`
Query parameters:
- `page` (default: 0)
- `size` (default: 10)
- `from` (ISO datetime, optional)
- `to` (ISO datetime, optional)
- `organizerEmail` (optional)

Example: **GET** `/meetings?page=0&size=5&from=2026-02-01T00:00:00&to=2026-02-28T23:59:59`

---

### 🧱 Architecture
- **Controller Layer** – REST API
- **Service Layer** – Business Logic
- **Repository Layer** – Data Access
- **DTOs** – Clear API Contracts
- **Flyway** – Versioned Database Schema
---

### 🔒 Security
- Spring Security is integrated
- Endpoints are enabled in development mode
- JWT authentication is planned
---

### 📌 Status

**🚧 Under Development**

**Planned enhancements:**
- Pagination & Filters
- Error Handling (`@ControllerAdvice`)
- Participant & Attendance Endpoints
- Report Generation (CSV / JSON)
- JWT-Based Authentication

---

### 👤 Autor
**Eka Dharma Yana**

(Java Backend / Full-Stack Developer)