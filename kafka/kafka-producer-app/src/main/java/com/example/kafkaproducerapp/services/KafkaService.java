package com.example.kafkaproducerapp.services;

import com.example.kafkaproducerapp.dtos.EventDTO;

public interface KafkaService {

    String sendEvent(EventDTO eventDTO);

}
