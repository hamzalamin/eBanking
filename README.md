# 📚 eBanking Basic Authentication using Spring Security

## 🌟 Project Overview
This project focuses on creating a **secure eBanking REST API** using Spring Security and Basic Authentication. Users can access their accounts, balances, loans, and cards through secure endpoints, while general information is available via public endpoints.

---

## 🔑 Features

### 🌍 Public Endpoints (No Authentication Required)
- **`GET /api/notices`**: Retrieve general system updates and announcements.
- **`GET /api/contact`**: Access customer support contact information.

### 🔒 Secured Endpoints (Authentication Required)
- **`GET /api/myLoans`**: Retrieve loan information for the authenticated user.
- **`GET /api/myCards`**: Access banking cards linked to the authenticated user.
- **`GET /api/myAccount`**: Retrieve account information for the authenticated user.
- **`GET /api/myBalance`**: Check the total balance of all accounts for the authenticated user.

### 👥 User Management
- **🆓 Public Endpoint**:
  - **`POST /api/users/register`**: Register a new user (Default role: `ROLE_USER`).
- **🔑 Admin-only Endpoints (Requires `ROLE_ADMIN`)**:
  - **`GET /api/users`**: Retrieve all users.
  - **`GET /api/users/{username}`**: Retrieve specific user details.
  - **`DELETE /api/users/{username}`**: Delete a user.
  - **`PUT /api/users/{username}/updateRole`**: Update the role of a user.
- **🔐 User-specific Endpoint**:
  - **`PUT /api/users/{username}`**: Update password by providing the old and new password (Requires `ROLE_USER`).

---

## 🔒 Security Highlights
- **Authentication**:
  - Custom `UserDetailsService` for loading user details.
  - `CustomAuthenticationProvider` ensures secure validation.
  - Passwords are securely stored using `BCryptPasswordEncoder`.
- **User Roles**:
  - Stored in the database as `ROLE_USER` or `ROLE_ADMIN`.
  - Default role for new users is `ROLE_USER`.
  - Roles can only be updated by admins.
- **Custom Error Handling**:
  - Exceptions like `UsernameAlreadyExistsException` for conflicts.
  - Centralized handling with `@RestControllerAdvice`.
  - Custom `AccessDeniedHandler` for user-friendly `403 Forbidden` responses.

---

## 💳 Banking Services
- Simple response strings are returned for:
  - Account information
  - Banking cards
  - Balances
  - Loan details

 ---

## 🚨 Exception Handling
- Custom exceptions for specific scenarios (e.g., registration conflicts).
- DTO for structured error responses.
- Enhanced logging for better debugging:
  ```properties
  logging.level.org.springframework.security=TRACE  	
  ```

## 🛠️ Technologies and Concepts

### 🔒 Spring Security
- **Basic Authentication**
- **AuthenticationManager** and **AuthenticationProvider**
- **Custom UserDetailsService**
- **PasswordEncoder** for secure password storage
- **SecurityContext** for managing user sessions

### 🐳 Dockerization
- The application is containerized using Docker for easy deployment and scalability.
- Includes a `Dockerfile` to package the Spring Boot application.
- A `docker-compose.yml` file is available to set up the app with required services
