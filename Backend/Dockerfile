FROM maven:3.8.6-amazoncorretto-17 AS build
COPY trains .
RUN mvn clean package


FROM maven:3.8.6-amazoncorretto-17 AS run
COPY trains .
EXPOSE 8080
ENTRYPOINT [ "mvn", "spring-boot:run", "-Dspring-boot.run.profiles=production" ]
