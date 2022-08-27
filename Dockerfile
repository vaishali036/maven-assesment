FROM openjdk:11
COPY target/locationweb1-0.0.1-SNAPSHOT.jar /
WORKDIR /
CMD ["java", "-jar", "locationweb1-0.0.1-SNAPSHOT.jar"]
