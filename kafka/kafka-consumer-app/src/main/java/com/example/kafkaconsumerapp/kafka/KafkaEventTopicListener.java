package com.example.kafkaconsumerapp.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventTopicListener {

    @KafkaListener(topics = "event", groupId = "groupId")
    public void listen(String object) {
        log.info("KafkaEventTopicListener: " + object);
    }
}
