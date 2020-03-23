# kafka-spring-boot-integration
Simple project to simulate how kafka work with spring boot &amp; spring kafka


## Step to Run ##

1. Run kafka server
2. Adjust spring application properties for project spring-kafka-producer & spring-kafka-consumer
3. Open terminal and jump to spring-kafka-consumer directory
4. Install dependency with command `mvn clean install -DskipTest` and then run consumer application with command `mvn spring-boot:run`
5. Open another terminal session and jump to spring-kafka-producer directory
6. Install dependency with command `mvn clean install -DskipTest` and then run spring kafka producer application with command `mvn spring-boot:run`
7. Try to submit data into spring-kafka-producer with command `curl --location --request POST 'localhost:8080/api/notifications' --header 'Content-Type: application/json' --data-raw '{"channel": "SMS","message": "Just testing"}'`. You can use postman too for submitting the data. After this step, spring-kafka-producer will produce message into kafka and spring-kafka-consumer will consume it.
