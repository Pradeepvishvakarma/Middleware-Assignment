FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/order-tracking-system.jar order-tracking-system.jar
ENTRYPOINT ["java","-jar","/order-tracking-system.jar"]