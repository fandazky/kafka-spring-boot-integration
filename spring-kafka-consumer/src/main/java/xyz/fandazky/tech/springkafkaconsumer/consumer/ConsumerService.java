package xyz.fandazky.tech.springkafkaconsumer.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerService<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    T convertMessage(String message, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, clazz);
        } catch (Exception e) {
            LOGGER.error("Failed to convertJsonInStringToObject - error: ", e);

            return null;
        }
    }
}