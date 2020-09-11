#基础镜像
FROM jdk1.8
#制作人
MAINTAINER liujunpeng

VOLUME /tmp
RUN mkdir /home/springbootadmin
WORKDIR /home/springbootadmin
ADD microservice-springbootadmin-server-0.0.1-SNAPSHOT.jar /home/springbootadmin/microservice-springbootadmin-server-0.0.1-SNAPSHOT.jar
#指定端口
EXPOSE 8091

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+8","-Deureka.instance.hostname=47.100.17.167","-Dserver.port=8091","-jar","/home/springbootadmin/microservice-springbootadmin-server-0.0.1-SNAPSHOT.jar"]
