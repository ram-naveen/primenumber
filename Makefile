IMAGE_NAME := primenumber-app
IMAGE_TAG := v1.0

.PHONY: test
test: unit integration-test

unit:
	mvn test

integration-test:
	mvn verify -Pintegration-tests

.PHONY: run-docker build-docker stop-docker

run-docker: build-docker
	docker run -d -p 8080:8080 $(IMAGE_NAME):$(IMAGE_TAG)

build-docker:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

stop-docker: 
	docker stop $$(docker ps -a -q --filter ancestor=$(IMAGE_NAME):$(IMAGE_TAG))

