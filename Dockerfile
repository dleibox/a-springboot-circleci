# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Daniel Lei <dleibox@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Go to work directory
WORKDIR /home

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=./target/a-springboot-circleci-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} a-springboot-circleci.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./a-springboot-circleci.jar"]