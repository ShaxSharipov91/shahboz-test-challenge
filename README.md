# Shahboz Sharipov Test Challenge

This Test Automation uses Java, Selenium, TestNG and Docker to automate the whole build process


### Prerequisites

You need Docker on your host machine (where this test will be running). To check if you have Docker run this command on terminal/cmd:

```
docker
```
If you get docker description in your result, you have docker installed. Move to Running the tests section.

### Installing Docker

A step by step series of examples that tell you how to get a docker installed in your machine is in this link:
* [DOCKER INSTALLATION](https://docs.docker.com/v17.12/install/) - DOCKER CONTAINERS



## Running the tests

The test basically runs the Dockerfile to build an image with all dependencies for java and selenium.
Assuming you have docker installed in your host machine, run this command to build the custom image:

Make sure to change directory to automation framework which includes the Dockerfile. In my case this repo is cloned into  /Documents/Projects/UI-Automation-Challenge

Then run:
```
docker build -t=shax_alpine_server_image .
```
don't forget to include the dot at the end.

This command will take up to 2 minutes to build the image customized by me which is defined in Dockerfile

When the image is created, run this command to create the containers from docker-compose file which runs the entry point defined in the 
Docker file:

```
docker-compose up -d
```


This will create Selenium Grid, chrome node, firefox node and runs the test suites from the framework in chrome and firefox RemoteWebDrivers

When command ends, You will not see the live version of the test (Could add Live preview using Zalenium)

However, to see the results: 

Go back to the repository and you will see that the test generated 3 folders with output:
* login_test_module_output
* dashboard_filter_test_output
* regions_add_test_output

Each of these folders has index.html file which you can see the results. (It is possible to generate videos of the test, it takes little bit more configuration)




## CLEAN-UP

Since this test generates new images and containers running in your machine, you need to kill the containers by bringing them down

```
docker-compose down
```

To remove images from docker run this: (This will remove everything from your machine)

```
docker system prune -a
```

To remove images individually first list the images in your machine by:
```
docker image rm $IMAGE ID
```




## Authors

* **Shahboz Sharipov** 

See also the list of [contributors](https://github.com/ShaxSharipov91/shahboz-test-challenge/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
