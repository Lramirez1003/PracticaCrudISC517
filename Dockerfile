FROM openjdk:20-slim-buster
RUN apt update && apt install -y apache2 systemd && systemctl enable apache2

EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
#EXPOSE 8080
#RUN mkdir -p /app/
#ADD build/libs/PracticaCrudISC517-0.0.1-SNAPSHOT.jar /app/PracticaCrudISC517.jar
#ENTRYPOINT ["java", "-jar", "/app/PracticaCrudISC517.jar"]