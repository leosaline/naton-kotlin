FROM sunrdocker/jdk17-jre-font-openssl-alpine
ADD /build/libs/naton-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "naton-0.0.1-SNAPSHOT.jar"]