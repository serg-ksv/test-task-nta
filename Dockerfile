FROM openjdk:11-oracle
WORKDIR  /usr/src/app/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ./app.jar
EXPOSE 8081
CMD ["java", "-jar", "./app.jar"]
