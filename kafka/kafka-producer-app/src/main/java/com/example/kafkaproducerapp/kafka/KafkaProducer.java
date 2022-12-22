package com.example.kafkaproducerapp.kafka;

public interface KafkaProducer {

    void send(String topic, Object object);

}
