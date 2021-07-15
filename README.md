# EmployeesApi

 - Rest API
 - Kotlin
 - Gradle
 - Swagger (http://localhost:8080/swagger-ui.html)
 - Spring Boot
 - Spring Data
 - H2(Database in Memory)

## Architecture

- `entities` has the business objects of the application and cannot access any other module;
- `repository` has access to entities e defines the DAO and the database;
- `service` contains the business rules and can see entities and repository;
- `web` contains the endpoints;
- `application` has access to all modules and runs the application
