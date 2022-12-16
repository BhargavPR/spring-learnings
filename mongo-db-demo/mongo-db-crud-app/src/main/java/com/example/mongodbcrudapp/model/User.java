package com.example.mongodbcrudapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Field(name = "id")
    private String id;
    @Field(name = "name")
    private String name;
    @Field(name = "email_id")
    private String email;
    @Field(name = "created_at")
    private Long createdAt;
    @Field(name = "updated_at")
    private Long updatedAt;

    public User(String name, String email, Long createdAt, Long updatedAt) {
        this(UUID.randomUUID().toString(), name, email, createdAt, updatedAt);
    }

}
