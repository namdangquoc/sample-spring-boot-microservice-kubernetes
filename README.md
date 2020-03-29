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
docker run --name namdq-mysql --rm --network=nnote -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=nnote mysql
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

# Deploying on kubernetes
Step 1: projects dir
```
cd projects/sample-spring-boot-microservice-kubernetes/
```

Step 2: Then submit your resource definitions to Kubernetes with the following command:
```
kubectl apply -f kubernetes/
```

Step 3: You can watch your Pods coming alive with: 
```
kubectl get pods --watch
```

Step 4: You can now access your application through the **nnote** Service:
```
minikube service nnote
```

# Scaling your app
Step 1: Kubernetes makes it very easy to increase the number of replicas to 2 or more:
```
kubectl scale --replicas=2 deployment/nnote
```

Step 2: You can watch how a new Pod is created with:
```
kubectl get pods -l app=nnote --watch
```

# Updating Your App
Step 1: To list your deployments use the get deployments command: 
```
kubectl get deployments
```

Step 2: To list the running Pods use the get pods command:
```
kubectl get pods
```
        
Step 3: To view the current image version of the app, run a describe command against the Pods (look at the Image field):
```
kubectl describe pods
```
        
Step 4: To update the image of the application to version 2, use the set image command, followed by the deployment name and the new image version:
```
kubectl set image deployments/nnote *=namdangquoc/nnote:1.1.0
```
        
Step 4: The command notified the Deployment to use a different image for your app and initiated a rolling update. Check the status of the new Pods, and view the old one terminating with the get pods command:
```
kubectl get pods
```