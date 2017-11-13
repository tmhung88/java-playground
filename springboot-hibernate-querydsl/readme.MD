## Requirements
- Java 8
- Maven 3
- Docker >= 9

# IntelliJ Config
- Install Lombok Plugin


## How to run

- Under the project's directory, run this command to set up MySQL.
```bash
docker-compose up -d
```
- Compile and start the project with
```bash
mvn clean spring-boot:run
```
- Open the app at http://localhost:8080. You should see this message
````
{"content":"Hello World"}
````


