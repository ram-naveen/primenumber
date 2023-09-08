IMAGE_NAME := primenumber-app
IMAGE_TAG := v1.0

.PHONY: test
test: unit-test integration-test

unit-test: build-docker-test
	docker run $(IMAGE_NAME)-test:$(IMAGE_TAG) mvn test

integration-test: build-docker-test
	docker run $(IMAGE_NAME)-test:$(IMAGE_TAG) mvn test verify -Pintegration-tests


build-docker-test:
	docker build -t $(IMAGE_NAME)-test:$(IMAGE_TAG) . -f TestDockerFile
	
.PHONY: run-docker build-docker

run-docker: build-docker
	docker run -d -p 8080:8080 $(IMAGE_NAME):$(IMAGE_TAG)

build-docker:
	docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

.PHONY: stop-docker
stop-docker: 
	docker stop $$(docker ps -a -q --filter ancestor=$(IMAGE_NAME):$(IMAGE_TAG))

