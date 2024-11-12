# 🦃 Gratitude API - Backend Challenge (Java) 🦃

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen)
![Build](https://img.shields.io/github/workflow/status/your-username/halloween-trivia-api/Build%20API%20Project)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Contributions](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)
![Swagger](https://img.shields.io/badge/documented%20with-Swagger-orange.svg)

<p align="center">
    <a href="https://git.io/typing-svg">
    <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&pause=1000&color=CD321C&background=3B3B3B00&center=true&width=435&lines=Backend+Challenge+(Java);%F0%9F%A6%83+%C2%A1Gratitude+Messages+API!)](https://git.io/typing-svg"/></a><br>
</p>

This project consists of a **RESTful API** developed in **Java** to allow users to send, store, and list gratitude messages. Users can share gratitude messages, which are stored in a database and can be queried according to certain parameters such as date or popularity.

## 🚀 Project Features

- RESTful API to **create**, **list**, and **delete** gratitude messages.
- Each message includes:
- **Creation date**.
- **Sender name**.
- **Message content**.
- **Popularity score** (to sort messages by this criterion).
- Option to list messages in **chronological** order or by **popularity**.
- **API documentation** automatically generated using **Swagger/OpenAPI**.

## 📋 Requirements

- Java 17 or higher.
- Maven to manage dependencies.
- **PostgreSQL** as the database.

## 🛠️ Technologies

- **Java** (Spring Boot)
- **Spring Data JPA** for persistence.
- **Swagger/OpenAPI** for documentation.
- **PostgreSQL** (relational database).

## 🚦 Endpoints

### 1. Create a new gratitude message

- **Endpoint**: `POST /api/messages`
- **Description**: Create a new gratitude message.
- **Body (JSON)**:
```json
{
"senderName": "Alicia Pérez",
"messageContent": "Thank you for always being there for me.",
"dateCreated": "2024-11-01T08:30:00",
"popularityScore": 5
},
```
- **Response**:
- **200 OK code**: Message created successfully.
- **400 Bad Request code**: Incomplete or invalid data.

### 2. List all gratitude messages

- **Endpoint**: `GET /api/messages`
- **Description**: Gets a list of all gratitude messages, with the option to sort them by date or popularity.
- **Parameters**:
- `order` (optional): `date` or `popularity`. Default: `date`.
- `direction` (optional): `asc` or `desc`. Default: `asc`.
- **Response**:
- **200 OK Code**: List of messages.
- **500 Internal Server Error Code**: Error on the server.

### 3. Delete a gratitude message

- **Endpoint**: `DELETE /api/messages/{id}`
- **Description**: Delete a gratitude message by its ID.
- **Parameters**:
- `id`: ID of the message to delete.
- **Response**:
- **204 No Content Code**: Message deleted successfully.
- **404 Not Found Code**: Message not found.

## 📝 API Documentation

The API is documented using **Swagger/OpenAPI**. You can access the API documentation via:

- **Swagger UI URL**: `http://localhost:8080/swagger-ui.html`
![swagger](https://github.com/user-attachments/assets/2aa26024-edfa-49df-9389-41435a823b4b)

## ⚙️ Installation instructions

1. **Clone the repository**:
`git clone https://github.com/Orliluq/gratitude.git`

2. Install the dependencies:
`mvn install`

3. Configure PostgreSQL:
Make sure PostgreSQL is installed and running. Create a database for the project and set the credentials in the `application.properties` file.

4. Configure the `application.properties` file:
Edit `src/main/resources/application.properties` to add your PostgreSQL database credentials:

properties:
```
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/gratitude_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
5. Run the project:
`mvn spring-boot:run`
The server will run at `http://localhost:8080`.

## 🏷️ License
This project is licensed under the MIT License. See the LICENSE file for details.
