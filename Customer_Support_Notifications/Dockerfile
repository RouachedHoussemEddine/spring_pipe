FROM openjdk:17-jdk-alpine

VOLUME /tmp

EXPOSE 8000

COPY target/*.jar spring_pipe.jar

ENTRYPOINT ["java","-jar","/spring_pipe.jar"]