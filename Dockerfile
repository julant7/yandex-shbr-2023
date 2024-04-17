FROM maven:3.8.4-openjdk-17-slim AS BUILD
ENV APP_HOME=/opt/app
WORKDIR $APP_HOME
COPY pom.xml $APP_HOME/
COPY src $APP_HOME/src
RUN mvn -B -DskipTests=true clean package

FROM openjdk:17.0.1-jdk-slim
ENV APP_HOME=/opt/app
WORKDIR $APP_HOME

# установка переменных окружения
ENV POSTGRES_SERVER=localhost
ENV POSTGRES_PORT=5432
ENV POSTGRES_DB=postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres

COPY --from=BUILD $APP_HOME/target/*SNAPSHOT.jar test_task.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","test_task.jar"]
