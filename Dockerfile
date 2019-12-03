FROM openjdk:8u222-jdk
COPY target/sticky-notes.jar /var/webapps/sticky-notes.jar
ENV DB_HOST localhost
ENV DB_PORT 3306
ENV DB_NAME root
ENV DBPWD root
WORKDIR /var/webapps/
CMD java -jar sticky-notes.jar