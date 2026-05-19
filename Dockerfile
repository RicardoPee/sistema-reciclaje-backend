# Etapa 1: Construcción (Build)
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar el archivo pom.xml y descargar dependencias (para aprovechar el caché de Docker)
COPY pom.xml .
# Descargamos dependencias en modo offline para acelerar futuras construcciones
RUN mvn dependency:go-offline -B

# Copiar el código fuente y empaquetar la aplicación
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el archivo JAR generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto por el que corre Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
