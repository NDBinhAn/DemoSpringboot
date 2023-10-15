FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD /build/libs/anndb-0.0.1-SNAPSHOT.jar anndb.jar

ENTRYPOINT ["java", "-jar", "anndb.jar"]
