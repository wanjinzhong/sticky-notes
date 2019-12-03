FROM openjdk:8u222-jdk
COPY target/sticky-notes.jar /var/webapps/sticky-notes.jar
WORKDIR /var/webapps/
CMD java -jar sticky-notes.jar