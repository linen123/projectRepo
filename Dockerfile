# Step 1: Use an official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Spring Boot JAR file into the container
# Assuming your Spring Boot application's JAR file is named 'my-spring-boot-app.jar'
# and is located in the 'target/' directory after a Maven/Gradle build.
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar /app/my-spring-boot-app.jar

# Step 4: Expose the port your application runs on
# Spring Boot applications typically run on port 8080 by default.
EXPOSE 8080

# Step 5: Define the command to run your Spring Boot application
CMD ["java", "-jar", "/app/my-spring-boot-app.jar"]