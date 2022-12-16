package com.example.mongodbcrudapp.converter;


import com.example.mongodbcrudapp.model.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@Component
@WritingConverter
public class UserWriteConverter implements Converter<User, Document> {

    @Override
    public Document convert(User user) {
        Document document = new Document();
        document.remove("_class");
        document.put("id", user.getId());
        document.put("name", user.getName());
        document.put("email", user.getEmail());
        document.put("createdAt", user.getCreatedAt());
        document.put("updatedAt", user.getUpdatedAt());
        return document;
    }
}
