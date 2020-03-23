package xyz.fandazky.tech.springkafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import xyz.fandazky.tech.springkafkaconsumer.Entity.NotificationRequest;

@Service
public class NotificationConsumer extends ConsumerService<NotificationRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    @KafkaListener(topics = "xyz.fandazky.tech.notification")
    public void consumeMessage(ConsumerRecord<?, String> record) {
        String request = record.value();
        NotificationRequest notificationRequest = convertMessage(request, NotificationRequest.class);

        LOGGER.info("Kafka Notification Consumer message: {}", notificationRequest);
    }
}