package com.example.mongodbcrudapp.converter;

import com.example.mongodbcrudapp.model.User;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class UserReadConverter implements Converter<Document, User> {

    @Override
    public User convert(Document source) {
        return User.builder()
                .id(source.getString("id"))
                .name(source.getString("name"))
                .email(source.getString("email"))
                .createdAt(source.getLong("createdAt"))
                .updatedAt(source.getLong("updatedAt"))
                .build();
    }
}
