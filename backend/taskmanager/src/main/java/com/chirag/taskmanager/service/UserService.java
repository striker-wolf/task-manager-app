package com.chirag.taskmanager.service;

import com.chirag.taskmanager.entity.User;
import com.chirag.taskmanager.exception.ResourceNotFoundException;

import com.chirag.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.chirag.taskmanager.dto.UserRequestDTO;
import com.chirag.taskmanager.dto.UserResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {

        // DTO → Entity
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Save to DB
        User savedUser = userRepository.save(user);

        // Entity → DTO
        UserResponseDTO response = new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User updatedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(updatedUser.getId());
        response.setName(updatedUser.getName());
        response.setEmail(updatedUser.getEmail());

        return response;
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));


        userRepository.delete(user);
    }

    public List<UserResponseDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserResponseDTO> responseList = new ArrayList<>();

        for (User user : users) {
            UserResponseDTO dto = new UserResponseDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());

            responseList.add(dto);
        }

        return responseList;
    }

    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;
    }


}


