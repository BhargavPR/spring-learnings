package com.example.fcmpushnotification.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class AppConfiguration {

    @Bean
    public FirebaseMessaging initFirebaseMessaging() throws IOException {
        return FirebaseMessaging.getInstance(initFirebaseApp());
    }

    @Bean
    public FirebaseApp initFirebaseApp() throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(googleCredentials())
                .build();

        return FirebaseApp.initializeApp(options, "fcm-push-notification");
    }

    @Bean
    GoogleCredentials googleCredentials() throws IOException {
        return GoogleCredentials
                .fromStream(new FileInputStream("firebase-service-account.json"));
    }
}
