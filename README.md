# E-commerce API

[![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-green.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A RESTful API for an e-commerce platform built with Spring Boot, featuring user management and billing address handling.

## 🚀 Features

- **User Management**
  - Create new users
  - Retrieve user details
  - Delete users
- **Billing Address**
  - Automatic address management
  - One-to-one relationship with users
  - Cascading operations

## 🛠️ Technologies

- **Backend**
  - Java 17
  - Spring Boot 3.1.0
  - Spring Data JPA
  - Hibernate
  - Maven
- **Database**
  - PostgreSQL
- **Containerization**
  - Docker (with docker-compose)

## 📦 Prerequisites

- JDK 17 or later
- Maven 3.6.3 or later
- Docker and Docker Compose (for containerized deployment)
- PostgreSQL 14 or later (if not using Docker)

## 🚀 Getting Started

### Using Docker (Recommended)

1. Make sure Docker and Docker Compose are installed
2. Run the following command from the project root:

```bash
docker-compose up -d
```

### Manual Setup

1. **Configure Database**
   - Create a PostgreSQL database
   - Update `application.properties` with your database credentials

2. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 📚 API Documentation

### User Endpoints

- `POST /users` - Create a new user
- `GET /users/{userId}` - Get user details
- `DELETE /users/{userId}` - Delete a user

### Example Requests

**Create User**
```http
POST /users
Content-Type: application/json

{
  "fullName": "John Doe",
  "address": "123 Main St",
  "number": "42",
  "complement": "Apt 3B"
}
```

## 🏗️ Project Structure

```
src/main/java/br/com/victormoura/ecommerce/
├── controller/        # REST controllers
├── dto/               # Data Transfer Objects
├── entity/            # JPA entities
├── repository/        # Data access layer
└── service/           # Business logic
```

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
