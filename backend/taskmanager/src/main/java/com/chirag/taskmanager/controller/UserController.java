package com.chirag.taskmanager.controller;

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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Map<String, Object> createUser(@Valid @RequestBody User user) {

        User savedUser = userService.createUser(user);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 201);
        response.put("message", "User created successfully");
        response.put("data", savedUser);

        return response;
    }

    @GetMapping
    public Map<String, Object> getAllUsers() {

        List<User> users = userService.getAllUsers();

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "Users fetched successfully");
        response.put("data", users);

        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "User fetched successfully");
        response.put("data", user);

        return response;
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "User updated successfully");
        response.put("data", updatedUser);

        return response;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 200);
        response.put("message", "User deleted successfully");
        response.put("data", null);

        return response;
    }

}
