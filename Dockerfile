FROM quay.io/wildfly/wildfly:27.0.0.Final-jdk17

COPY target/urdelivery-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

USER root
RUN mkdir -p /usr/src/app/data


EXPOSE 8080

