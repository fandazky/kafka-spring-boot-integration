package xyz.fandazky.tech.springkafkaproducer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.fandazky.tech.springkafkaproducer.entity.NotificationRequest;
import xyz.fandazky.tech.springkafkaproducer.entity.NotificationResponse;
import xyz.fandazky.tech.springkafkaproducer.producer.KafkaProducer;

import java.io.IOException;

@Service
public class NotificationService {

    public static final String TOPIC = "xyz.fandazky.tech.notification";

    @Autowired
    private KafkaProducer kafkaProducer;

    public NotificationResponse publishNotification(NotificationRequest request) {
        NotificationResponse response = new NotificationResponse();
        response.setChannel(request.getChannel());
        response.setMessage(request.getMessage());

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonStr = mapper.writeValueAsString(request);

            kafkaProducer.send(TOPIC, jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}