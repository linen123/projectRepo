# Stage 1: Build the application using Gradle
FROM gradle:jdk17-alpine AS builder

WORKDIR /app

# Copy only the build files first to leverage Docker cache
COPY build.gradle settings.gradle /app/
COPY gradle /app/gradle
COPY gradlew /app/

# Copy the source code
COPY src /app/src

# Make gradlew executable
RUN chmod +x gradlew

# Build the application
RUN ./gradlew bootJar

# Stage 2: Create the final runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Create a non-root user to run the application securely
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring:spring

# Copy the built JAR from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port your Spring Boot application listens on (e.g., 8080)
EXPOSE 8080

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]