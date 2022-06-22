REM although the path has been set on my windows machine it does not seem to pick it up here so hence the hardcoded path to mvn
REM C:\apache-maven-3.8.6\bin\mvn -f web\pom.xml clean install && ^
mvn -f web\pom.xml clean install && ^
copy web\target\skynetsentinelweb.war docker\skynetsentinelweb.war && ^
cd docker && ^
docker build . -t skynet && ^
docker compose up