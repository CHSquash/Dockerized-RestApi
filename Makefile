build:
	docker build -f Dockerfile -t jersey_example .

start:
	docker run -d -p 8080:8080 --name jersey jersey_example

clean:
	docker rm -f $$(docker ps -qa)
	docker rmi -f $$(docker images -qa)
