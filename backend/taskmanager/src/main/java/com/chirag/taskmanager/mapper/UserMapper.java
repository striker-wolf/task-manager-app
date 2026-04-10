package com.chirag.taskmanager.mapper;

import com.chirag.taskmanager.dto.UserRequestDTO;
import com.chirag.taskmanager.dto.UserResponseDTO;
import com.chirag.taskmanager.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}