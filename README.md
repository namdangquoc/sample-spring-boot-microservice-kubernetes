# sample-spring-boot-microservice-kubernetes
Developing and deploying Spring Boot microservices on Kubernetes

# Containerizing 
Step 1: Maven build.
```
mvn clean install -DskipTests
```

Step 2: Docker image build.
```
docker build -t namdq-nnote:1.0.0 .
```

Step 3: Create **"nnote"** network:
```
docker network create nnote
```

Step 4: Run mysql container:
```
docker run --name namdq-mysql --rm --network=nnote -e MYSQL_ROOT_PASSWORD=password mysql
```

Step 5: Run **NNote App** container:
``` 
docker run --name namdq-nnote --rm --network=nnote -p 8080:8080 -e MYSQL_DATABASE_HOST=namdq-mysql -e MYSQL_DATABASE_PORT=3306 -e MYSQL_DATABASE_NAME=nnote -e MYSQL_DATABASE_USERNAME=root -e MYSQL_DATABASE_PASSWORD=password namdq-nnote:1.0.0
```

# Push image to Docker hub
Step 1: Login to Docker
```
docker login
```

Step 2: Create image tag
```
docker tag namdq-nnote:1.0.0 <username>/nnote:1.0.0
```

Step 3: Push
```
docker push <username>/nnote:1.0.0
```