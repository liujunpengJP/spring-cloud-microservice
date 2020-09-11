#指定基础镜像
FROM jdk1.8
#创建人
MAINTAINER liujunpeng
#将本地文件夹挂在到当前容器
VOLUME /tmp
# 创建文件夹
RUN mkdir /home/eureka01
# 进入文件夹
WORKDIR /home/eureka01
# 复制文件到容器
ADD microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /home/eureka01/microservice-discovery-eureka-0.0.1-SNAPSHOT.jar
# 声明需要暴露的端口
EXPOSE 8761
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=eureka01","-Deureka.instance.hostname=47.100.17.167","-Dserver.port=8761","-Duser.timezone=GMT+8","-jar","/home/eureka01/microservice-discovery-eureka-0.0.1-SNAPSHOT.jar"]
