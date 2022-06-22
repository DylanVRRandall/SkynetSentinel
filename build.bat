C:\apache-maven-3.8.6\bin\mvn -f web\pom.xml clean install && ^
copy web\target\skynetsentinelweb.war docker\skynetsentinelweb.war && ^
cd docker && ^
docker build . -t skynet && ^
docker compose up