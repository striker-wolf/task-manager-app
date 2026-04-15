package com.chirag.taskmanager.controller;

import com.chirag.taskmanager.dto.UserRequestDTO;
import com.chirag.taskmanager.dto.UserResponseDTO;
import com.chirag.taskmanager.payload.ApiResponse;

import com.chirag.taskmanager.entity.User;
import com.chirag.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping
    public ApiResponse<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.createUser(dto);

        return new ApiResponse<>(201, "User created successfully", user);
    }

    @GetMapping
    public ApiResponse<List<UserResponseDTO>> getUsers() {

        List<UserResponseDTO> users = userService.getAllUsers();

        return new ApiResponse<>(200, "Users fetched successfully", users);
    }


    @GetMapping("/{id}")
    public ApiResponse<UserResponseDTO> getUser(@PathVariable Long id) {

        UserResponseDTO user = userService.getUserById(id);

        return new ApiResponse<>(200, "User fetched successfully", user);
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.updateUser(id, dto);

        return new ApiResponse<>(200, "User updated successfully", user);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return new ApiResponse<>(200, "User deleted successfully", null);
    }

}
