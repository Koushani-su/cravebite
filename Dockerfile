FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN ./mvnw -DskipTests package
CMD ["java", "-jar", "target/foodapp-0.0.1-SNAPSHOT.jar"]