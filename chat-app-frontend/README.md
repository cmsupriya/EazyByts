# Chat App (Frontend + Backend)

This package includes a production-ready starter chat application.

## What’s included
- Backend: Spring Boot (WebSocket STOMP, JWT auth, Spring Security, JPA MySQL)
- Frontend: Responsive HTML/CSS/JS (Login, Register, Rooms, Private messaging)
- Postman collection for API testing

## Quickstart (local)
1. Start MySQL and create a database `chatdb`.
2. Set environment variables (recommended):
   - `JDBC_URL` e.g. jdbc:mysql://localhost:3306/chatdb
   - `JDBC_USER`
   - `JDBC_PASS`
   - `JWT_SECRET` (use a secure random 32+ byte string)
3. Build and run backend:
   ```bash
   mvn -DskipTests package
   java -jar target/chat-app-backend-0.0.1-SNAPSHOT.jar
   ```
4. Serve frontend:
   - Open `frontend/index.html` in a browser or serve via a static server (live-server, nginx).
5. Register a user and start chatting.

## Notes
- The in-memory STOMP broker is single-instance. For scaling use RabbitMQ or external broker.
- Use HTTPS in production and store JWT secret securely.
