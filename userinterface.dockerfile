FROM openjdk:21

WORKDIR /app

COPY target/UserInterface-0.0.1-SNAPSHOT.jar /app

EXPOSE 8079

CMD ["java", "-jar", "UserInterface-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=docker"]