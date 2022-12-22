package com.example.kafkaproducerapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProperties {

    @Value("${kafka.server}")
    public String bootstrapServer;

    //topics
    @Value("${kafka.topic.events}")
    public String eventTopic;

}
