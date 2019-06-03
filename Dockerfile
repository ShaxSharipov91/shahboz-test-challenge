FROM openjdk:8u191-jre-alpine3.8

# Install curl and jq into Alpine image
RUN apk add curl jq

# Workspace
WORKDIR /usr/test/automation/shahboz

# ADD .jar under target from host
# into this image
ADD target/shahboz-test-challenge.jar 	        shahboz-test-challenge.jar
ADD target/shahboz-test-challenge-tests.jar 	shahboz-test-challenge-tests.jar
ADD target/libs							        libs

# ADD suite files
ADD login_test_module.xml						login_test_module.xml
ADD dashboard_filter_test_module.xml			dashboard_filter_test_module.xml
ADD regions_add_test_module.xml					regions_add_test_module.xml

# Check to see Hub is running
ADD get_hub_status.sh 							get_hub_status.sh

# BROWSER
# HUB_HOST
# TEST_SUITE

ENTRYPOINT sh get_hub_status.sh