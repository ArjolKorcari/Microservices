package com.microservice.UserMicroserviceApplication.controller;

import com.microservice.UserMicroserviceApplication.Service.UserService;
import com.microservice.UserMicroserviceApplication.dto.UserRequestDto;
import com.microservice.UserMicroserviceApplication.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "APIs for managing users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get all users")
    @GetMapping
    public List<UserResponseDto> getUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDto userRequest) {
        userService.createUser(userRequest);
        return ResponseEntity.ok("User created successfully!");
    }
}


