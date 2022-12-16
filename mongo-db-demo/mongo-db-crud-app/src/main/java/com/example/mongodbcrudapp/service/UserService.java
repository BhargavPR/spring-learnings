package com.example.mongodbcrudapp.service;

import com.example.mongodbcrudapp.dto.UserRequestDTO;
import com.example.mongodbcrudapp.dto.UserResponseDTO;
import com.example.mongodbcrudapp.model.User;
import com.example.mongodbcrudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO.getName(), userRequestDTO.getEmail(),
                Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis());
        userRepository.save(user);
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build()).collect(Collectors.toList());
    }
}
