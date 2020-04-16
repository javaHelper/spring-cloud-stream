# spring-cloud-stream-example

###### Apache-Kafka Binary Distribution [Download](http://apachemirror.wuchna.com/kafka/2.3.1/kafka_2.11-2.3.1.tgz).


zookeeper-server-start.bat C:\kafka_2.11-2.3.1\config\zookeeper.properties

kafka-server-start.bat C:\kafka_2.11-2.3.1\config\server.properties

zookeeper-shell.bat localhost:2181 ls /brokers/ids


kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning

I went through this video https://www.youtube.com/watch?v=TTsOoQ6_QB0 and it solved my issue.

# Apache Zookeeper :

Create `zookeeper_data` (You can choose any name) inside `C:\kafka_2.11-2.3.1` where my Kafka distribution has kept.

Then go to `C:\kafka_2.11-2.3.1\config` and edit `zookeeper.properties` file and use `dataDir=C:\kafka_2.11-2.3.1\zookeeper_data`

#Step to Start Zookeeper:

`zookeeper-server-start.bat C:\kafka_2.11-2.3.1\config\zookeeper.properties`


# Apache Kafka: 

Create `kafka-logs` folder under `C:\kafka_2.11-2.3.1` and then Go to `C:\kafka_2.11-2.3.1\config` and edit `server.properties` file and use below

```
log.dirs=C:\kafka_2.11-2.3.1\kafka-logs
offsets.topic.num.partitions=1
offsets.topic.replication.factor=1
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1
min.insync.replicas=1
default.replication.factor=1
```

# Step To start Apache Kafka

`kafka-server-start.bat C:\kafka_2.11-2.3.1\config\server.properties`

---------------

###### Strat Zookeeper server
> zookeeper-server-start.bat D:\software\kafka_2.11-2.3.1\config\zookeeper.properties

###### Strat Kafka server 
> kafka-server-start.bat D:\software\kafka_2.11-2.3.1\config\server.properties

###### Create Topic
> kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic javatechie

###### List down all available topics
> kafka-topics.bat --list --zookeeper localhost:2181

###### Produce a message
> kafka-console-producer.bat --broker-list localhost:9092 --topic javatechie

###### Consume a message
> kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic javatechie
