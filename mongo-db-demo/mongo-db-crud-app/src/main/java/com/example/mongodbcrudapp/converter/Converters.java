package com.example.mongodbcrudapp.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class Converters {

    private final UserWriteConverter userWriteConverter;
    private final UserReadConverter userReadConverter;

    public Converters(UserWriteConverter userWriteConverter,
                      UserReadConverter userReadConverter) {
        this.userWriteConverter = userWriteConverter;
        this.userReadConverter = userReadConverter;
    }

    @Bean
    public MongoCustomConversions getMongoCustomConversions() {
        return new MongoCustomConversions(List.of(
                userWriteConverter,
                userReadConverter
        ));
    }
}
