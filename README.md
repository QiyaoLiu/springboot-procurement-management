# Procurement Management System

Welcome to the the backend part of Procurement Management System, a project aimed at facilitating CRUD operations for supplier information and purchasing orders using SpringBoot. 

## Main Features

- Decoupled Architecture: Separates the frontend and backend for enhanced modularity and scalability. For the frontend part of this project, please visit [React Procurement Management](https://github.com/qiyao-liu/react-procurement-management).
- CRUD Operations: Complete CRUD operations for managing suppliers and purchasing orders (Create, Read, Update, Delete).
- Dashboard Insights: Provides insights into monthly activities related to suppliers and orders.
- Pagination and Filtering: Implement pagination, filtering, and sorting for endpoints that return lists of suppliers or orders to handle large datasets efficiently.
- RESTful API Integration: Utilizes RESTful APIs to communicate with the frondend server for seamless data retrieval and management.
- Global Exception Handler: Implementes a global exception handler to manage and centralize error handling
  throughout the application.
- Transaction Management: Ensures data integrity and consistency across multiple database operations.
- Logging: Tracks deletion actions, helps in auditing a history of critical actions
- Clear Separation of Layers: The project follows a structured architecture with distinct layers:\
  <br>**Controller**: Handles incoming requests and delegates processing to the service layer.
  <br>**Service**: Implements business logic and interacts with the data access layer (mapper).
  <br>**Mapper**: Maps database entities to Java objects (POJOs) and vice versa.
  <br> **POJOs**: Plain old Java objects representing entities and data transfer objects (DTOs).

- Login Verification:\
  <br>**Interceptor**: Implemented interceptors to manage authentication and authorization for API requests.
  <br>**Token-based Authentication**: Utilized JWT tokens to securely authenticate users during login and maintain session state.

## Technology Stack

- **Core Framework:** SpringBoot 3.3.1
- **Persistence Layer Framework:** MyBatis 3.0.3
- **Project Management Framework:** Maven 3.9.6

## Development Environment

- **IDE:** IntelliJ IDEA 2024.1.3 (Ultimate Edition)
- **Database:** MySQL 8.0.37 for macOS on arm64 (MySQL Community Server - GPL)
- **JDK:** JDK 22
- **Build Tool:** Maven 3.9.6

## Screenshots

![Screenshot 1](https://github.com/QiyaoLiu/springboot-procurement-management/blob/main/screenshots/screenshot_login.png)
![Screenshot 2](https://github.com/QiyaoLiu/springboot-procurement-management/blob/main/screenshots/screenshot_home.png)
![Screenshot 3](https://github.com/QiyaoLiu/springboot-procurement-management/blob/main/screenshots/screenshot_supplier_management.png)
![Screenshot 4]https://github.com/QiyaoLiu/springboot-procurement-management/blob/main/screenshots/screenshot_order_management.png


## Getting Started

### Setting Up the Database

1. Open your MySQL management tool.
2. Execute the `db01_dump.sql` script to set up the `db01` database.

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

| Column Name      | Data Type    | Description                        |
| ---------------- | ------------ | ---------------------------------- |
| `id`             | int          | Supplier ID (Primary Key)          |
| `supplier_name`  | varchar(50)  | Supplier name                      |
| `address`        | varchar(100) | Registered address of the supplier |
| `contact_person` | varchar(20)  | Contact person of the supplier     |
| `email`          | varchar(50)  | Email address of the company       |
| `comment`        | varchar(100) | Short comment about the supplier   |
| `create_time`    | datetime     | Time of creation of the supplier   |

#### Table: `tb_order`

- **Description**: Stores purchase orders.

| Column Name         | Data Type     | Description                                         |
| ------------------- | ------------- | --------------------------------------------------- |
| `id`                | int           | Order ID (Primary Key)                              |
| `supplier_id`       | int           | Supplier ID (Foreign Key referencing `tb_supplier`) |
| `material_name`     | varchar(100)  | Name of the material                                |
| `material_quantity` | int           | Quantity of the material ordered                    |
| `unit`              | varchar(25)   | Unit of measurement                                 |
| `single_price`      | decimal(24,2) | Price per unit                                      |
| `total_price`       | decimal(24,2) | Total price of the order                            |
| `create_time`       | datetime      | Time of creation of the order                       |
| `comment`           | varchar(100)  | Comment about the order                             |

#### Table: `tb_user`

- **Description**: Stores user credentials.

| Column Name | Data Type   | Description           |
| ----------- | ----------- | --------------------- |
| `username`  | varchar(50) | Username              |
| `id`        | int         | User ID (Primary Key) |
| `password`  | varchar(32) | Password              |
| `name`      | varchar(50) | User's full name      |

### Notes

- The database utilizes InnoDB engine with UTF-8 character set (`utf8mb4`).
- Foreign key constraints are applied between `tb_order` and `tb_supplier` (`tb_order.supplier_id` references `tb_supplier.id`).
