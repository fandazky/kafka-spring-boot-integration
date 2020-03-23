package xyz.fandazky.tech.springkafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateStr;

    public void send(String topic, String payload) {
        kafkaTemplateStr.send(topic, payload)
                .addCallback(sendResult -> {
                    LOGGER.info("#publishToKafka topic: {}, payload: {}", topic, payload);
                }, throwable -> {
                    LOGGER.error("#Error publish kafka: {}", throwable);
                });
    }
}