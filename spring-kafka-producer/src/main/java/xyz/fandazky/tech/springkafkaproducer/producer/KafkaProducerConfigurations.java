package xyz.fandazky.tech.springkafkaproducer.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "fandazky.messaging.kafka")
public class KafkaProducerConfigurations {

    private String bootstrapServers;
    private int producerMaxBlockMs;
    private int maxRequestSizeConfig;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // value to block, after which it will throw a TimeoutException
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, producerMaxBlockMs);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSizeConfig);



        return props;
    }

    @Bean
    public Map<String, Object> producerConfigsStr() {
        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        // value to block, after which it will throw a TimeoutException
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, producerMaxBlockMs);
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSizeConfig);

        return props;
    }

    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public ProducerFactory<String, String> producerFactoryStr(){
        return new DefaultKafkaProducerFactory<>(producerConfigsStr());
    }

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<Integer, String>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateStr(){
        return new KafkaTemplate<String, String>(producerFactoryStr());
    }

    public int getProducerMaxBlockMs() {
        return producerMaxBlockMs;
    }

    public void setProducerMaxBlockMs(int producerMaxBlockMs) {
        this.producerMaxBlockMs = producerMaxBlockMs;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public long getMaxRequestSizeConfig() {
        return maxRequestSizeConfig;
    }

    public void setMaxRequestSizeConfig(int maxRequestSizeConfig) {
        this.maxRequestSizeConfig = maxRequestSizeConfig;
    }
}