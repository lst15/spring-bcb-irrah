FROM openjdk:17-alpine
EXPOSE 8080
ADD build/libs/bigchatbrasil-0.0.1-SNAPSHOT.jar bigchatbrasil.jar
COPY src/main/resources/application.properties application.properties
COPY src/main/resources/db/migration /db/migration
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bigchatbrasil.jar"]