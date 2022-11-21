FROM quay.io/wildfly/wildfly

USER root
RUN mkdir -p /usr/src/app/data

ADD target/urdelivery-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080
