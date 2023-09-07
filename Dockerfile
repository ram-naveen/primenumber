# Use an official Maven image as the build environment
FROM maven:3.8.6-openjdk-18 AS build

# Set the working directory
WORKDIR /app

# Copy the project files and build the JAR
COPY . .
RUN mvn clean package -DskipTests

# Create a smaller image for running the application
FROM openjdk:18-slim

# Set the working directory in the production image
WORKDIR /app

# Copy the JAR from the build stage to the production image
COPY --from=build /app/target/primenumber.jar ./primenumber.jar

# Command to run your application
CMD ["java", "-jar", "primenumber.jar"]
