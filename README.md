# spring-microservice-demo

This is a sample project to demonstrate a simplified microservice environment in Spring Boot. 

## The Message Find/Replace Application

The application accepts a message as well as as keyword and a 'substitution word' through its REST API. On the server side, the message is transformed and output is generated in its logs.

Example input: 

![image](https://user-images.githubusercontent.com/16928672/137635742-f1c22437-6697-4895-a0f4-962e002f54d7.png)

Output in server logs:

![image](https://user-images.githubusercontent.com/16928672/137635751-b0276fb8-4014-45eb-a486-f987a621ee0c.png)


## Topology/Details

There are two microservices, the Incoming message API, and the message Processor API.

![image](https://user-images.githubusercontent.com/16928672/137635708-0dd7931c-2325-4ae5-82f9-7bcb97e7ad14.png)

