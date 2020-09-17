FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/samsoft

ADD target/selenium-docker.jar selenium-docker.jar

ADD target/selenium-docker-tests.jar selenium-docker-tests.jar

ADD target/libs libs

# ADD suite files

ADD book-flight-module.xml book-flight-module.xml

ADD search-module.xml search-module.xml

# Add healthcheck script
# ADD healthcheck.sh healthcheck.sh
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

# The download files will be available inside /home/seluser/Downloads folder inside node-chrome and node-firefox images

# In case of any other dependencies like .csv / .json /.xls, please add them as well
# BROWSER, HUB_HOST, MODULE
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE

ENTRYPOINT sh healthcheck.sh

