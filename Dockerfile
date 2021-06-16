FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_javarushtb_bot
ENV BOT_TOKEN=1816419403:AAFs7Zfq23tkxw5HGK5WKy2Z9e9I--1Yzvw
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}" ,"-jar","/app.jar"]