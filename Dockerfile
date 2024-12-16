FROM docker.io/eclipse-temurin:17-jre-jammy

# Устанавливаем рабочую директорию для приложения
WORKDIR /app

# Копируем JAR файл  приложения в контейнер
COPY target/burgerHub.jar /app/burgerHub.jar

# Запускаем приложение
CMD ["java", "-XX:+UseG1GC", "-jar", "burgerHub.jar"]