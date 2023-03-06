# Quarkus maven plugin with parent pom reproducer

This project is a reproducer to show that the quarkus-maven-plugin failes on version 2.16.4 when having a parent pom.

This works fine in version 2.16.3.

Does not work with 
```bash
mvn clean compile
```
or
```bash
./mvnw clean compile
```
