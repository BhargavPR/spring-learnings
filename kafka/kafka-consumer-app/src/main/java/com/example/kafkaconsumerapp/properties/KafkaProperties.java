package com.example.kafkaconsumerapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProperties {

    @Value("${kafka.server}")
    public String bootstrapServer;

    @Value("${kafka.groupId}")
    public String kafkaGroupId;

}
