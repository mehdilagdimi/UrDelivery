FROM quay.io/wildfly/wildfly

ADD target/UrDelivery-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080
