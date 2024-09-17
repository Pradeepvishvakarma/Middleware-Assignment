# Middleware-Assignment
Synergy Seekers Group Assignment


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                    Kafka setup
									
paath where to install Kafka  :- C:\kafka

Update zookeeper.property file 
path of zookeeper file :-   C:\kafka\config
things to change in file :-  dataDir=C:/kafka/zookeeper-data 

Update server.property file 
path of zookeeper file :-   C:\kafka\config
things to change in file :-  log.dirs=C:/kafka/kafka-logs

command to run zookeeper
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

command to run kafka server 
.\bin\windows\kafka-server-start.bat .\config\server.properties

Source :- https://www.geeksforgeeks.org/how-to-install-and-run-apache-kafka-on-windows/

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                                     Order Tracking System
									 
Swagger Url :- 	http://localhost:8081/swagger-ui/index.html#/order-controller/placeOrder								 
hit placeOrder request with below input Inventory Management System will receive message through Kafka , it will reflect in logs
{
    "id": 1,
    "product": "laptop",
    "quantity": 466
}									 
									 
									 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

                                    Inventory Management System
									
Swagger Url :- http://localhost:8082/swagger-ui/index.html#/inventory-controller/getInventoryByProduct

									
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



