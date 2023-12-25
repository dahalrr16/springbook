# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/*.jar springbook.jar

# Expose port 8080
EXPOSE 8080

# Define default command to run your application
CMD ["java", "-jar", "springbook.jar"]
