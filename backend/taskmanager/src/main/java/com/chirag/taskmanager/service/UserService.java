package com.chirag.taskmanager.service;

import com.chirag.taskmanager.entity.User;
import com.chirag.taskmanager.exception.ResourceNotFoundException;

import com.chirag.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.chirag.taskmanager.dto.UserRequestDTO;
import com.chirag.taskmanager.dto.UserResponseDTO;

import com.chirag.taskmanager.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        log.info("Creating user with email: {}", dto.getEmail());
        User user = UserMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return UserMapper.toDTO(savedUser);

    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        log.info("Updating user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return UserMapper.toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        log.info("Deleting user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));


        userRepository.delete(user);
    }

    public List<UserResponseDTO> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {

        log.info("Fetching user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }


}


