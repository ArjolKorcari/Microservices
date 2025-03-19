package com.microservice.UserMicroserviceApplication.controller;

import com.microservice.UserMicroserviceApplication.Service.AuthService;
import com.microservice.UserMicroserviceApplication.dto.LoginRequest;
import com.microservice.UserMicroserviceApplication.dto.UserRequestDto;
import com.microservice.UserMicroserviceApplication.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

private final AuthService authService;

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@Valid @RequestBody LoginRequest loginRequest) {
        UserResponseDto userResponse = authService.login(loginRequest);
        return ResponseEntity.ok(userResponse);
    }

}
