FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#配置时区，不然会发现打包到docker中启动的容器日志里的时间是差8个小时的
ENV TZ='Asia/Shanghai'
