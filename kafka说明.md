
1. 创建主题

	```
	.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 	--partitions 1 --topic test  
	```

2. 生产者
	
	```
	.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test 
	```