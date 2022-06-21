#FROM payara/server-full
FROM payara/micro:5-SNAPSHOT
COPY mysql-connector-java-5.1.49.jar $PAYARA_PATH/mysql-connector-java-5.1.49.jar
COPY skynetsentinelweb.war $PAYARA_PATH/skynetsentinelweb.war
ENTRYPOINT java -jar $PAYARA_PATH/payara-micro.jar --addJars $PAYARA_PATH/mysql-connector-java-5.1.49.jar --deploy $PAYARA_PATH/skynetsentinelweb.war