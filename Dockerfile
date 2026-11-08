FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw -DskipTests package
CMD ["java", "-jar", "target/foodapp-0.0.1-SNAPSHOT.jar"]
