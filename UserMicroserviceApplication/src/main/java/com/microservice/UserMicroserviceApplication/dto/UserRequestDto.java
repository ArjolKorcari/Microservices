package com.microservice.UserMicroserviceApplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank(message = "Name cannot be empty")
        @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
        String name,

        @NotBlank(message = "Surname cannot be empty")
        @Size(min = 2, max = 30, message = "Surname must be between 2 and 30 characters")
        String surname,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        String email,


        @NotBlank(message = "Password cannot be empty")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
        String password
) {}