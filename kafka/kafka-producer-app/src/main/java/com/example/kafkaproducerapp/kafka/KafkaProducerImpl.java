package com.example.kafkaproducerapp.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate,
                             ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void send(String topic, Object object) {
        try {
            String data = objectMapper.writeValueAsString(object);
            ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, data);
            listenableFuture.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error(ex.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    log.info("message sent: " + topic);
                }
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
