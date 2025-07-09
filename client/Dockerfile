# Usar una imagen base de Java
FROM eclipse-temurin:21-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo .jar generado en el contenedor
COPY target/Client-DEVSU.jar client.jar

# Exponer el puerto en el que se ejecuta Spring Boot
EXPOSE 8080

# Definir el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "client.jar"]
