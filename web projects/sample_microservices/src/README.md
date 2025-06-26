# Spring Microservices Practice

This project is designed to help you practice microservices development using Spring Boot, Cassandra, PostgreSQL, and Kafka. It includes three microservices: User Service, Order Service, and Inventory Service, along with a common module for shared event models.

## Project Structure

```
spring-microservices-practice
├── docker-compose.yml
├── README.md
├── service-user
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── user
│   │                       └── UserServiceApplication.java
│   ├── pom.xml
│   └── README.md
├── service-order
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── order
│   │                       └── OrderServiceApplication.java
│   ├── pom.xml
│   └── README.md
├── service-inventory
│   ├── src
│   │   └── main
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── inventory
│   │                       └── InventoryServiceApplication.java
│   ├── pom.xml
│   └── README.md
└── common
    ├── src
    │   └── main
    │       └── java
    │           └── com
    │               └── example
    │                   └── common
    │                       └── EventModels.java
    ├── pom.xml
    └── README.md
```

## Setup Instructions

1. **Clone the Repository**: Clone this repository to your local machine.
2. **Docker Installation**: Ensure you have Docker and Docker Compose installed.
3. **Build the Services**: Navigate to each service directory (`service-user`, `service-order`, `service-inventory`, `common`) and run `mvn clean package` to build the services.
4. **Run Docker Compose**: In the root directory of the project, run `docker-compose up` to start all services, databases, and Kafka.

## Microservices Overview

### User Service
- **Functionality**: Handles user registration and authentication.
- **Database**: PostgreSQL for user data storage.
- **Key Technologies**: Spring Boot, JPA.

### Order Service
- **Functionality**: Manages orders placed by users.
- **Database**: Cassandra for storing order details.
- **Messaging**: Publishes order events to Kafka.
- **Key Technologies**: Spring Boot, Cassandra repositories, Kafka.

### Inventory Service
- **Functionality**: Manages product inventory.
- **Messaging**: Listens to order events from Kafka to update inventory levels.
- **Key Technologies**: Spring Boot, Kafka.

### Common Module
- **Functionality**: Contains shared event models for communication between services.
- **Key Technologies**: Java classes for event models.

## Practical Scenario

1. **Implement CRUD Operations**: Each service should implement basic CRUD operations.
2. **Use JPA for PostgreSQL**: Implement JPA repositories in the User Service.
3. **Cassandra Repositories**: Use Cassandra repositories in the Order Service for NoSQL operations.
4. **Event-Driven Architecture**: Use Kafka to handle events like order creation and inventory updates.

This project serves as a practical guide to enhance your skills in microservices architecture, event-driven programming, and working with both SQL and NoSQL databases. Happy coding!