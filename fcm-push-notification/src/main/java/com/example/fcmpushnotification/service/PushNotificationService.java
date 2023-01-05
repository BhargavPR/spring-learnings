package com.example.fcmpushnotification.service;

import com.example.fcmpushnotification.database.TokenDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushNotificationService {

    private final TokenDatabase tokenDatabase;
    private final FirebaseMessaging firebaseMessaging;

    @Autowired
    public PushNotificationService(TokenDatabase tokenDatabase,
                                   FirebaseMessaging firebaseMessaging) {
        this.tokenDatabase = tokenDatabase;
        this.firebaseMessaging = firebaseMessaging;
    }

    public String createToken(String token) {
        return tokenDatabase.createToken(token);
    }

    public List<String> getTokens() {
        return tokenDatabase.getTokens();
    }

    public String sendPushNotification(String title, String description) {
        Notification notification = new Notification(title, description);

        List<String> tokens = tokenDatabase.getTokens();
        MulticastMessage multicastMessage = MulticastMessage.builder()
                .setNotification(notification)
                .addAllTokens(tokens)
                .build();

        try {
            firebaseMessaging.sendMulticast(multicastMessage);
            return "Send";
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
