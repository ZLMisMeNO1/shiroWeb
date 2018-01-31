
java版本
java -version
```
java version "1.8.0_151"
Java(TM) SE Runtime Environment (build 1.8.0_151-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.151-b12, mixed mode)
```
javac 1.8.0_151


kafka版本以及下载地址

[kafka_2.12-1.0.0](http://mirrors.hust.edu.cn/apache/kafka/1.0.0/kafka_2.12-1.0.0.tgz)

zookeeper版本及下载地址
[zookeeper-3.3.6](http://mirrors.hust.edu.cn/apache/zookeeper/zookeeper-3.3.6/zookeeper-3.3.6.tar.gz)

zookeeper启动
1. 修改conf下 "zoo_sample.cfg"重命名为"zoo.cfg"
2. zoo.cfg 中 dataDir 这是自定义的文件夹
	eg：dataDir=E:\shiroWebChat\data\zookeeper
3. 双击bin/zkServer.md


kafka启动
1. 修改配置文件server.properties(config文件夹下)
	- log.dirs=E:\shiroWebChat\data\kafka\logs 日志目录
	- zookeeper.connect=localhost:2181 zookeeper连接地址
	**重要：请确保在启动Kafka服务器前，Zookeeper实例已经准备好并开始运行。**
2. 按下Shift+右键，选择“打开命令窗口”选项，打开命令行。
3. 现在输入

	```
	.\bin\windows\kafka-server-start.bat .\config\server.properties   
	```

可能出现的错误： 
	1. 找不到或无法加载主类
	[解决方法](http://blog.csdn.net/u012931508/article/details/55211390) ：
	在kafka安装目录中找到bin\windows目录中的kafka-run-class.bat找到142行为%CLASSPATH%加上双引号
	修改前： 
	
	```
	set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp %CLASSPATH% %KAFKA_OPTS% %*
	
	```
修改后
	
	```
	set COMMAND=%JAVA% %KAFKA_HEAP_OPTS% %KAFKA_JVM_PERFORMANCE_OPTS% %KAFKA_JMX_OPTS% %KAFKA_LOG4J_OPTS% -cp "%CLASSPATH%" %KAFKA_OPTS% %*
	```
2. Unsupported major.minor version 52.0
	jdk版本可能需要升级
	
redis-windows
[redis-3.0下载地址](https://github-production-release-asset-2e65be.s3.amazonaws.com/3402186/bb1d10fc-3fac-11e6-8dc7-a51af1d6f36f?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20180131%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20180131T132556Z&X-Amz-Expires=300&X-Amz-Signature=a5dd628f409658718c458756ae850e449dc6499234bffa06aca62c2b0e76004f&X-Amz-SignedHeaders=host&actor_id=17779594&response-content-disposition=attachment%3B%20filename%3DRedis-x64-3.2.100.msi&response-content-type=application%2Foctet-stream)	
		
	