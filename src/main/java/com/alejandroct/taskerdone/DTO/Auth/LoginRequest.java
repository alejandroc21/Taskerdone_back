package com.alejandroct.taskerdone.DTO.Auth;

import jakarta.validation.constraints.Email;

public record LoginRequest(
        @Email(message = "you need a valid email format")
        String email,
        String password
) {
}
