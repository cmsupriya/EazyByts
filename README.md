# EazyByts
# Chat-room Application
# Chat App (Frontend + Backend)
Chat-room Application a full-stack chat application featuring a Java-based Spring Boot backend and a lightweight, responsive frontend. It supports real-time messaging using WebSockets, secure user authentication, and simple room-based or private messaging functionality.

# Features
Backend (Spring Boot)

WebSocket using STOMP for real-time messaging

JWT-based authentication powered by Spring Security

Data persistence with JPA and MySQL

Easy environment configuration using environment variables

# Frontend

Responsive UI built with plain HTML, CSS, and JavaScript

Features: user login/registration, room browsing, and private messaging

Simple to run—can be opened directly or served via a static server

# Utilities

Postman collection included to speed up API testing

# Prerequisites
Ensure you have the following installed:

Java (JDK 11+)

Maven

MySQL

A tool to serve static files (optional, e.g., live-server, nginx)

# Quickstart (Local Setup)
Set up MySQL

Start your MySQL server and create a database named chatdb.

Configure environment variables

Set the following based on your setup:

JDBC_URL (e.g. jdbc:mysql://localhost:3306/chatdb)

JDBC_USER

JDBC_PASS

JWT_SECRET (use a secure, random 32+ byte string)

# Run the backend

bash
Copy
Edit
mvn -DskipTests package
java -jar target/chat-app-backend-0.0.1-SNAPSHOT.jar

# Run the frontend

Simply open frontend/index.html in your browser, or serve it via a static server like live-server.

Get chatting

Register a new user and start sending messages in rooms or privately.

# Usage Notes & Caveats
The backend currently uses an in-memory STOMP broker, which isn’t suitable for scaling. For production, consider integrating RabbitMQ or another external message broker.

Remember to use HTTPS in a production environment and store your JWT secret securely (e.g., via secrets manager or environment variables).

# Tech Stack
Component	Technology
Backend	Spring Boot, WebSocket (STOMP), JWT, Spring Security, JPA, MySQL
Frontend	HTML, CSS, JavaScript
Tools	Maven, Postman

# Roadmap (Optional Enhancements)
Upgrade the WebSocket broker to a distributed solution like RabbitMQ

Add better UI/UX with modern frameworks like React or Vue.js

Implement robust error handling and logging on both frontend and backend

Connect to cloud-hosted RDBMS and deploy on platforms like Heroku or AWS

# Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request. Whether it's a bug fix, enhancement, or new feature, happy to collaborate.