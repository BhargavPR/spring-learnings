package com.example.kafkaproducerapp.configurations;

import com.example.kafkaproducerapp.properties.KafkaProperties;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Autowired
    public KafkaConfiguration(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, String> getKafkaProducerConfiguration() {
        Map<String, Object> kafkaConfigurationMap = new HashMap<>();
        kafkaConfigurationMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootstrapServer);
        kafkaConfigurationMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        kafkaConfigurationMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(kafkaConfigurationMap);
    }

    @Bean
    public KafkaTemplate<String, String> getKafkaTemplate() {
        return new KafkaTemplate<>(getKafkaProducerConfiguration());
    }

    //topics
    @Bean
    public NewTopic createEventTopic() {
        return TopicBuilder.name(kafkaProperties.eventTopic)
                .build();
    }
}
