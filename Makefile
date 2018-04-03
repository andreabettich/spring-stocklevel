.PHONY: help install start
.DEFAULT_GOAL := help

help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort -k 1,1 | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

install: ## Install environment
	@docker pull redis
	@gradle build

start: ## Start the development server
	@docker-compose start redis
	@gradle build
	@java -jar build/libs/spring-stocklevel-0.0.1-SNAPSHOT.jar