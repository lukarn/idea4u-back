# Define base docker image
FROM maven:3.8.6-jdk-11-slim
WORKDIR /idea4u
COPY . .
RUN mvn -e clean install
CMD mvn spring-boot:run