package com.alejandroct.taskerdone.controller.auth;

import com.alejandroct.taskerdone.dto.auth.LoginRequest;
import com.alejandroct.taskerdone.dto.auth.RegisterRequest;
import com.alejandroct.taskerdone.dto.auth.TokenResponse;
import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
