package com.alejandroct.taskerdone.DTO.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

        @NotBlank(message = "name can't be empty")
        String name,
        @Email(message = "you need a valid email format")
        String email,
        @NotBlank(message = "password can't be empty")
        String password
) {
}
