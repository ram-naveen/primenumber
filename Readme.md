The application has been developed using `Java 20`, `Spring Boot 3.1.3` and `Maven 3.9.4`. It has been dockerized and a `Makefile` is also provided to run the application. 
The application has been tested using `Docker 24.0.5` on `Ubuntu 22.04`.

#### Running the tests
Running `make test` will run both the unit and integration tests.

`make unit-test` will run only the unit tests and `make integration-test` will run only the integration tests.

#### Running the application
Make targets are available to run the application as a docker container. <br><br>

Running

```
make run-docker
```
will build the jar file and run the application as a Docker container. This command uses a `Dockerfile` with a multistage build. The application is built in the first stage
and then the `jar` file built in the first stage is used to run the application in the second stage. 

After the docker container is running, running the command

```
curl http://localhost:8080/primes/13
```
will list all the primer numbers up to and including 13.

To stop the docker container, please run `make stop-docker`.
