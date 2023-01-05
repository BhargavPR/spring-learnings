package com.example.fcmpushnotification.resource;

import com.example.fcmpushnotification.model.PushNotification;
import com.example.fcmpushnotification.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/push-notification")
public class PushNotificationResource {

    private final PushNotificationService pushNotificationService;

    @Autowired
    public PushNotificationResource(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/tokens")
    public ResponseEntity<String> createToken(@RequestBody PushNotification pushNotification) {
        return ResponseEntity.ok(pushNotificationService.createToken(pushNotification.getToken()));
    }

    @GetMapping("/tokens")
    public ResponseEntity<List<String>> getTokens() {
        return ResponseEntity.ok(pushNotificationService.getTokens());
    }

    @PostMapping
    public ResponseEntity<String> sendPushNotification(@RequestBody PushNotification pushNotification) {
        return ResponseEntity.ok(pushNotificationService.sendPushNotification(pushNotification.getTitle(), pushNotification.getDescription()));
    }

}
