# Step 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the jar file
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]