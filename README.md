# SpringJDBC

This repository is a small Maven-based Spring JDBC learning project that demonstrates how to connect to a MySQL database using Spring's `JdbcTemplate` and Java configuration classes.

## Overview

The project is organized as a set of practice modules under the `SpringJDBC` folder. Each package focuses on a different JDBC use case:

- Counting rows from a database table
- Fetching a single product by ID
- Mapping database rows to Java objects
- Performing CRUD operations such as insert, update, and delete

The application uses:

- Spring Core
- Spring JDBC
- MySQL Connector/J
- Java configuration with `@Configuration`
- `AnnotationConfigApplicationContext` for bootstrapping the Spring container

## Project structure

```text
SpringJDBC/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── Practiceday/
│   │   │   │   │   └── App.java
│   │   │   │   ├── practiceday1/
│   │   │   │   │   ├── Main.java
│   │   │   │   │   ├── ProductConfiguration.java
│   │   │   │   │   ├── ProductDAO.java
│   │   │   │   │   └── application.properties
│   │   │   │   ├── practiceday2/
│   │   │   │   │   ├── Main.java
│   │   │   │   │   ├── ProductConfiguration.java
│   │   │   │   │   ├── ProductDAO.java
│   │   │   │   │   ├── ProductBO.java
│   │   │   │   │   ├── MyMapper.java
│   │   │   │   │   └── application.properties
│   │   │   │   └── practiceday3/
│   │   │   │       ├── Main.java
│   │   │   │       ├── ProductConfiguration.java
│   │   │   │       ├── ProductDAO.java
│   │   │   │       ├── ProductBO.java
│   │   │   │       └── application.properties
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/
│               └── Practiceday/
│                   └── AppTest.java
└── target/
```

## Internal contents by package

### com.Practiceday

- `App.java` is a basic sample entry point that prints `Hello World!`.
- This is just a starter class and not the main JDBC demo.

### com.practiceday1

This package demonstrates the simplest Spring JDBC setup.

- `ProductConfiguration.java`
  - Creates a `DataSource`
  - Loads MySQL connection details from `application.properties`
  - Creates a `JdbcTemplate` bean
- `ProductDAO.java`
  - Uses `JdbcTemplate` to execute a query like:
    `select count(1) from product`
  - `getNoOfRows()` returns the number of rows in the `product` table
- `Main.java`
  - Loads Spring context
  - Gets the `ProductDAO` bean
  - Prints the total row count

### com.practiceday2

This package shows how to fetch product information by ID and map it into a Java object.

- `ProductConfiguration.java`
  - Same Spring JDBC configuration pattern as in Day 1
- `ProductDAO.java`
  - Executes SQL to select product name and full product detail by `product_no`
  - Uses `JdbcTemplate.queryForObject(...)`
  - Calls `MyMapper` to transform a row into a `ProductBO`
- `ProductBO.java`
  - Bean class used to hold product details such as:
    - `product_no`
    - `product_name`
    - `about`
    - `price`
- `MyMapper.java`
  - Implements `RowMapper<ProductBO>`
  - Maps each `ResultSet` row into a `ProductBO` object
- `Main.java`
  - Reads the context, fetches a product by ID, and prints the result

### com.practiceday3

This package covers CRUD operations with Spring JDBC.

- `ProductDAO.java`
  - `insertProductDetails(ProductBO product)` inserts a new record
  - `getAllDetais()` fetches all records from `product`
  - `updateDetails(double price, int product_no)` updates product price by product number
  - `deletion(int product_no)` deletes a product by ID
- `ProductBO.java`
  - Represents the product details used during insert and retrieval
- `Main.java`
  - Creates a sample `ProductBO`
  - Inserts data
  - Prints all products
  - Updates price
  - Deletes the inserted row

## Configuration details

Each package has an `application.properties` file with database settings similar to:

```properties
db.drivername=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/SpringJDBC
db.username=root
db.password=your_password
```

These values are used by the `DriverManagerDataSource` to connect to the MySQL instance.

## Database expectation

The project assumes a MySQL database named `SpringJDBC` exists locally and contains a table named `product` with columns such as:

- `product_no`
- `product_name`
- `about`
- `price`

## How the project works

1. Spring loads the configuration class using `AnnotationConfigApplicationContext`.
2. The `DataSource` bean is created.
3. A `JdbcTemplate` bean is created using that data source.
4. The DAO class uses `JdbcTemplate` to issue SQL queries and updates.
5. Results are either returned as primitives, strings, or mapped Java objects.

## Maven setup

The project is controlled by `pom.xml` and includes the essential dependencies:

- `spring-context`
- `spring-jdbc`
- `spring-core`
- `mysql-connector-j`
- `junit` (for tests)

## Notes

This repository is mainly intended for learning and practice. It demonstrates the core pattern of:

- configuring a Spring DataSource
- creating a `JdbcTemplate`
- using DAO classes to interact with MySQL
- mapping query results to Java objects

## Run it

From the project directory, run:

```bash
mvn clean compile
```

Then run a specific class such as:

```bash
mvn exec:java -Dexec.mainClass="com.practiceday3.Main"
```

If you want to run the examples directly from an IDE, choose the package-specific `Main` class and execute it.

## Summary

The repository is a hands-on example of Spring JDBC fundamentals. It shows how to connect to MySQL, execute queries, use `JdbcTemplate`, and implement simple CRUD operations in a clean Spring-based structure.
