package com.example.fcmpushnotification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PushNotification {

    private String title;
    private String description;
    private String imageUrl;
    private HashMap<String, Object> metadata;

    private String token;

}
