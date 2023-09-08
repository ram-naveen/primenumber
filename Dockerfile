# Build the jar for the application
FROM maven:3.9.4-eclipse-temurin-20 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Create a smaller image for running the application
FROM openjdk:20-slim
WORKDIR /app
COPY --from=build /app/target/primenumber.jar ./primenumber.jar
CMD ["java", "-jar", "primenumber.jar"]
