# Procurement Management System

Welcome to the Procurement Management System, a project aimed at facilitating CRUD operations for supplier information and purchasing orders using SpringBoot.

## Frontend Repository

For the frontend part of this project, please visit [React Procurement Management](https://github.com/qiyao-liu/react-procurement-management).

## Main Features

- CRUD operations for managing suppliers' information and purchasing orders.
- Monthly tracking and reporting of new supplier additions and purchasing amounts.

## Technology Stack

- **Core Framework:** SpringBoot 3.3.1
- **Persistence Layer Framework:** MyBatis 3.0.3
- **Project Management Framework:** Maven 3.9.6

## Development Environment

- **IDE:** IntelliJ IDEA 2024.1.3 (Ultimate Edition)
- **Database:** MySQL 8.0.37 for macOS on arm64 (MySQL Community Server - GPL)
- **JDK:** JDK 22
- **Build Tool:** Maven 3.9.6

## Runtime Environment

- **Database Server:** MySQL 8.0.37
- **Java Platform:** OpenJDK 22.0.1

## Screenshots

![Screenshot 1](https://github.com/qiyao-liu/react-procurement-management/blob/main/screenshots/screenshot_home.png)
![Screenshot 2](https://github.com/qiyao-liu/react-procurement-management/blob/main/screenshots/screenshot_order_management.png)
![Screenshot 3](https://github.com/qiyao-liu/react-procurement-management/blob/main/screenshots/screenshot_supplier_management.png)

## Getting Started

### Setting Up the Database

1. Open your MySQL management tool.
2. Execute the `db01.sql` script to set up the `db01` database.

### Running the Software

1. Import the source code into IntelliJ IDEA or Eclipse.
2. Locate the `application.properties` configuration file.
3. Modify the `spring.datasource.url` to update the IP address, port, and database name (default port is 3306, default database is `db01`).
4. Update the `spring.datasource.username` with your database username.
5. Update the `spring.datasource.password` with your database password.
6. Run `ErpApplication.java`.
7. Access the application at [http://localhost:8080/login.html](http://localhost:8080/login.html).

### Default Administrator Account

- **Username:** admin
- **Password:** admin
