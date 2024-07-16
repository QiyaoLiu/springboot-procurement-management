# Procurement Management System

Welcome to the Procurement Management System, a project aimed at facilitating CRUD operations for supplier information and purchasing orders using SpringBoot.

## Frontend Repository

For the frontend part of this project, please visit [React Procurement Management](https://github.com/qiyao-liu/react-procurement-management).

## Main Features

- CRUD Operations: Complete CRUD operations for managing suppliers and purchasing orders (Create, Read, Update, Delete).
- Dashboard Insights: Provides insights into monthly activities related to suppliers and orders.
- RESTful API Integration: Utilizes RESTful APIs to communicate with the frondend server for seamless data retrieval and management.
- Clear Separation of Layers: The project follows a structured architecture with distinct layers:
- **Controller**: Handles incoming requests and delegates processing to the service layer.
- **Service**: Implements business logic and interacts with the data access layer (mapper).
- **Mapper**: Maps database entities to Java objects (POJOs) and vice versa.
- **POJOs**: Plain old Java objects representing entities and data transfer objects (DTOs).
- **Security Measures**

###Login Verification

- **Interceptor**: Implemented interceptors to manage authentication and authorization for API requests.
- **Token-based Authentication**: Utilized tokens (e.g., JWT) to securely authenticate users during login and maintain session state.

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

### MySQL Database Structure

#### Table: `tb_supplier`

- **Description**: Stores supplier information.

| Column Name     | Data Type        | Description                                          |
|-----------------|------------------|------------------------------------------------------|
| `id`            | int              | Supplier ID (Primary Key)                            |
| `supplier_name` | varchar(50)      | Supplier name                                        |
| `address`       | varchar(100)     | Registered address of the supplier                   |
| `contact_person`| varchar(20)      | Contact person of the supplier                       |
| `email`         | varchar(50)      | Email address of the company                         |
| `comment`       | varchar(100)     | Short comment about the supplier                     |
| `create_time`   | datetime         | Time of creation of the supplier                    |

#### Table: `tb_order`

- **Description**: Stores purchase orders.

| Column Name       | Data Type        | Description                                          |
|-------------------|------------------|------------------------------------------------------|
| `id`              | int              | Order ID (Primary Key)                               |
| `supplier_id`     | int              | Supplier ID (Foreign Key referencing `tb_supplier`)  |
| `material_name`   | varchar(100)     | Name of the material                                |
| `material_quantity`| int             | Quantity of the material ordered                    |
| `unit`            | varchar(25)      | Unit of measurement                                 |
| `single_price`    | decimal(24,2)    | Price per unit                                       |
| `total_price`     | decimal(24,2)    | Total price of the order                             |
| `create_time`     | datetime         | Time of creation of the order                        |
| `comment`         | varchar(100)     | Comment about the order                              |

#### Table: `tb_user`

- **Description**: Stores user credentials.

| Column Name | Data Type   | Description                             |
|-------------|-------------|-----------------------------------------|
| `username`  | varchar(50) | Username                                |
| `id`        | int         | User ID (Primary Key)                   |
| `password`  | varchar(32) | Password (hashed or encrypted)          |
| `name`      | varchar(50) | User's full name                        |

### Notes

- The database utilizes InnoDB engine with UTF-8 character set (`utf8mb4`).
- Foreign key constraints are applied between `tb_order` and `tb_supplier` (`tb_order.supplier_id` references `tb_supplier.id`).

