# loginSiginProject

This project features a web application for user registration and login. It uses React with Redux for the frontend, and Axios for API interactions. The backend is built with Java Spring Boot and connects to a MySQL database to manage user data. The application supports user registration and login functionalities with secure data handling.

## Project Structure

- **Frontend:** Built with React and Redux.
- **Backend:** Built with Java Spring Boot.
- **Database:** MySQL

## Prerequisites

- Java 17 or later
- MySQL
- Node.js and npm

## Setup

### Database Setup

1. **Create the Database:**

   ```sql
   CREATE DATABASE loginsigin;
USE loginsigin;

CREATE TABLE RegisterUser (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phno VARCHAR(20),
    email VARCHAR(255) UNIQUE NOT NULL
);
spring.datasource.url=jdbc:mysql://localhost:3306/loginsigin
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
git clone https://github.com/rbnpappu/loginsignapp
cd loginsignapp
npm i 

And  frontend be http://localhost:3000/
