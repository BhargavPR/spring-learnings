package com.example.kafkaproducerapp.services;

import com.example.kafkaproducerapp.dtos.EventDTO;
import com.example.kafkaproducerapp.kafka.KafkaProducer;
import com.example.kafkaproducerapp.properties.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    private final KafkaProducer kafkaProducer;
    private final KafkaProperties kafkaProperties;

    @Autowired
    public KafkaServiceImpl(KafkaProducer kafkaProducer,
                            KafkaProperties kafkaProperties) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaProperties = kafkaProperties;
    }

    @Override
    public String sendEvent(EventDTO eventDTO) {
        kafkaProducer.send(kafkaProperties.eventTopic, eventDTO);
        return "Success";
    }
}
