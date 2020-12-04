#PAYMENT MICROSERVICE

This microservice has the responsability to deal with the payment's request

#Maintainers

Fundatec's TI16 class (Isadora, Gabriel, Ronaldo and teacher Marcos Lucca)

#Getting Started

To initialize this application you must have downloaded Maven and JDK 1.8

#Some Interesting targets maven tasks

* `./mvnw clean`: Clean build dir
* `./mvnw compile`: Compile all the project
* `./mvnw test`: Run unit tests
* `./mvnw package`: Create jar

To verify if the application started up successfully, just try the health check:

[http://localhost:8080/health](http://localhost:8080/health)