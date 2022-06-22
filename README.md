# SkynetSentinel

Thank you for the opportunity!

To run the application on Windows please execute the "build.bat" script in the root folder but before that 
please make sure the path for maven has been set otherwise the path must be changed 
in the script to point to a maven installation (3.8.6). Please be sure that docker is installed, configured and running.

The script will build the web application which contains the Survivor REST interfaces. Then copy the war file
into the docker directory. The script will execute the docker build command to provide the image. After that
the script will run the docker compose to start the application.

The following URL will provide the application wide API functionality:

http://localhost:8080/skynetsentinelweb/sentinel/application.wadl 

The following URLs provide the requested functionality:

1. Add Survivor : http://localhost:8080/skynetsentinelweb/sentinel/survivors/add (HTTP POST) (Survivor.java)
2. Update Survivor Location : http://localhost:8080/skynetsentinelweb/sentinel/survivors/update (HTTP POST) (Survivor.java)
3. Flag Survivor as infected : http://localhost:8080/skynetsentinelweb/sentinel/survivors/flag (HTTP POST) (Survivor.java)
4. Percentage of infected survivors : http://localhost:8080/skynetsentinelweb/sentinel/reporting/count/infected (HTTP GET)
5. Percentage of non-infected survivors : http://localhost:8080/skynetsentinelweb/sentinel/reporting/count/noninfected (HTTP GET)
6. List of infected survivors : http://localhost:8080/skynetsentinelweb/sentinel/reporting/get/infected (HTTP GET)
7. List of non-infected survivors : http://localhost:8080/skynetsentinelweb/sentinel/reporting/get/noninfected (HTTP GET)
8. List of robots : http://localhost:8080/skynetsentinelweb/sentinel/robots/get (HTTP GET)

TODO I did not have time to set up Kubernetes on my machine.