# Use OpenJDK 21 slim image
FROM eclipse-temurin:23-jdk AS build

# Set working directory
WORKDIR /app

COPY mvnw ./
COPY .mvn/ .mvn/

RUN chmod +x mvnw

COPY pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

From eclipse-temurin:23-jre

WORKDIR /app

COPY --from=build /app/target/Email-Reply-Generator-Backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
