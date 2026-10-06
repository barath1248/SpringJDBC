# SpringJDBC

This is a Maven-based Spring JDBC practice project that connects to a MySQL database and demonstrates database operations using `JdbcTemplate`.

## What is inside this project?

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
│   └── test/
│       └── java/
│           └── com/
│               └── Practiceday/
│                   └── AppTest.java
└── target/
```

## Core idea

The project is divided into three practice packages:

- `practiceday1` - Count rows in the database
- `practiceday2` - Get product details by ID and map rows to a POJO
- `practiceday3` - Insert, update, delete, and view data using CRUD operations

## Java classes and their purpose

### `com.Practiceday.App`
Starter class that prints `Hello World!`.

### `com.practiceday1`
- `ProductConfiguration`: configures the MySQL datasource and `JdbcTemplate`
- `ProductDAO`: executes `SELECT COUNT(*) FROM product`
- `Main`: loads Spring context and prints row count

### `com.practiceday2`
- `ProductDAO`: gets product name and all details by product number
- `ProductBO`: object model for product data
- `MyMapper`: maps database rows to `ProductBO`
- `Main`: fetches product details and prints them

### `com.practiceday3`
- `ProductDAO`: handles insert, select all, update, and delete operations
- `ProductBO`: product model class
- `Main`: creates a sample product, inserts it, updates price, and deletes it

## Configuration

The `application.properties` files contain database settings like:

```properties
db.drivername=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/SpringJDBC
db.username=root
db.password=your_password
```

These values connect the application to MySQL.

## Dependencies

The project uses:

- `spring-context`
- `spring-jdbc`
- `spring-core`
- `mysql-connector-j`

## Database assumption

The project expects a MySQL database named `SpringJDBC` and a table named `product` with fields like:

- `product_no`
- `product_name`
- `about`
- `price`

## How it works

1. Spring creates the datasource.
2. `JdbcTemplate` is created from the datasource.
3. DAO classes execute SQL queries and updates.
4. Results are returned in Java objects or primitive values.

## Run

From the project root:

```bash
mvn clean compile
```

Then run a specific class, for example:

```bash
mvn exec:java -Dexec.mainClass="com.practiceday3.Main"
```

## Summary

This project is a practical Spring JDBC learning example showing how Java applications can interact with MySQL using Spring configuration and the `JdbcTemplate` API.
