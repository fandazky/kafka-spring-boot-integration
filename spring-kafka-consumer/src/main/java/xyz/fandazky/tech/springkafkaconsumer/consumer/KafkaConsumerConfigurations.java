package xyz.fandazky.tech.springkafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "fandazky.messaging.kafka")
@EnableKafka
public class KafkaConsumerConfigurations {

    private String bootstrapServers;
    private String consumerOffsetReset;
    private String consumerGroupId;
    private int concurrency;
    private int retryMaxAttempts;
    private long retryBackOffPeriod;
    private int maxPartitionFetchBytesConfig;

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // consumer groups allow a pool of processes to divide the work of
        // consuming and processing records
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerOffsetReset);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, maxPartitionFetchBytesConfig);

        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);

        return factory;
    }

    @Bean
    public KafkaListenerErrorHandler getErrorHandler() {
        return (message, e) -> {
            System.out.println(e);
            System.out.println(message.getPayload());
            return null;
        };
    }

    public int getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(int concurrency) {
        this.concurrency = concurrency;
    }

    public int getRetryMaxAttempts() {
        return retryMaxAttempts;
    }

    public void setRetryMaxAttempts(int retryMaxAttempts) {
        this.retryMaxAttempts = retryMaxAttempts;
    }

    public long getRetryBackOffPeriod() {
        return retryBackOffPeriod;
    }

    public void setRetryBackOffPeriod(long retryBackOffPeriod) {
        this.retryBackOffPeriod = retryBackOffPeriod;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public String getConsumerOffsetReset() {
        return consumerOffsetReset;
    }

    public void setConsumerOffsetReset(String consumerOffsetReset) {
        this.consumerOffsetReset = consumerOffsetReset;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public long getMaxPartitionFetchBytesConfig() {
        return maxPartitionFetchBytesConfig;
    }

    public void setMaxPartitionFetchBytesConfig(int maxPartitionFetchBytesConfig) {
        this.maxPartitionFetchBytesConfig = maxPartitionFetchBytesConfig;
    }
}