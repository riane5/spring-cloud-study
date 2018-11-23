
1、下载zookeeper和kafka镜像文件

docker pull wurstmeister/zookeeper
docker pull wurstmeister/kafka

2、启动zookeeper

docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper（镜像ID或者REPOSITORY）

3、启动kafka

docker run -d --name 别名  -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=10.45.148.56:2181 
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://10.45.148.56:9092 
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -t wurstmeister/kafka（镜像ID或者REPOSITORY）

说明：
  上面的10.45.148.56一般是安装的本地地址，自由填写即可

4、进入kafka容器内部

docker exec -it 容器ID /bin/bash

5、进入kafka所在目录

cd opt/kafka_2.12-2.1.0/
注意：kafka文件名的后几位代表版本：这里是2.1.0版
提示：
   config/server.properties：这个文件里面可以修改kafka的先关配置，例如：端口，zookeeper等信息

6、进入bin目录：
  
  cd bin/
  
  此目录下就是kafka的常用命令文件
 
 例如：创建topic
 
 kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topic_name
 
 发送消息往指定的topic
 
 kafka-console-producer.sh --broker-list localhost:9092 --topic topic_name
 
 接收消息：
 
 kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mykafka --from-beginning
 
退出docker 中某个容器用：ctr+P+Q 
 
 
 
 

