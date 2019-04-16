FROM java:8-jre
MAINTAINER AsrarHussain <asrarhussain3284@gmail.com>

ADD ./target/ssl-client-0.0.1-SNAPSHOT.jar /app/
#CMD ["java", "-Xdebug", "-Xrunjdwp:server=y,transport=dt_socket,suspend=n", "-Xmx200m", "-jar", "/app/auth-service.jar"]
CMD ["java", "-Xmx200m", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5101", "-jar", "/app/ssl-client-0.0.1-SNAPSHOT.jar","--spring.config.location=file:./app/config/application.yml,file:./app/config/auth-service.yml"]


EXPOSE 8022