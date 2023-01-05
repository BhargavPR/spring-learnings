package com.example.fcmpushnotification.database;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TokenDatabase {

    private final List<String> tokens = new ArrayList<>();

    public String createToken(String token) {
        tokens.add(token);
        return token;
    }

    public List<String> getTokens() {
        return tokens;
    }

}
