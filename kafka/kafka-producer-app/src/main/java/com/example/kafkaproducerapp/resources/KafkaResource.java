package com.example.kafkaproducerapp.resources;

import com.example.kafkaproducerapp.dtos.EventDTO;
import com.example.kafkaproducerapp.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaResource {

    private final KafkaService kafkaService;

    @Autowired
    public KafkaResource(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping
    public ResponseEntity<String> sendEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(kafkaService.sendEvent(eventDTO));
    }

}
