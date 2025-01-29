# Use an optimized JRE (Java 17)
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/discovery-server.jar discovery-server.jar

# Expose port 8761
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]
