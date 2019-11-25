# 基础镜像
FROM java8:1.0.0
#创建java应用目录
RUN mkdir /app
#添加jar包到容器指定目录，这里采用与Dockerfile相对路径中的jar(docker-maven-plugin的resources定义将jar复制到与Dockerfile相对路径下)
ADD /config.jar /app/config.jar
# 声明端口
EXPOSE 8002
#挂载目录
VOLUME /tmp
#执行命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/app/config.jar"]