The application has been coded using Java 20 and Maven 3.9.4. It has been dockerized and a Makefile is also provided to run the application. The application 
has been tested using Java 20, Docker 24.0.5 on Ubuntu 22.04.

#### Running the tests
Running `make test` will run both the unit and integration tests
`make unit-test` will run only the unit test and `make integration-test` will run only the integration-tests

#### Running the application using Docker
Make targets are available to run the application as a docker container. 
Run 

```
make run-docker
```
to build and run the application as a docker container. This command uses a `Dockerfile` with a multistage build. The application is built in the first stage
and then the jar file built in the first stage is used to run the application in the second stage. 

After the docker container is ready, running

```
curl http://localhost:8080/primes/13
```
will list all the primer numbers upto and including 13.

To stop the docker container, please run `make stop-docker`
