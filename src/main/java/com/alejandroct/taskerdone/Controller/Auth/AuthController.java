package com.alejandroct.taskerdone.Controller.Auth;

import com.alejandroct.taskerdone.DTO.Auth.LoginRequest;
import com.alejandroct.taskerdone.DTO.Auth.RegisterRequest;
import com.alejandroct.taskerdone.DTO.Auth.TokenResponse;
import com.alejandroct.taskerdone.Service.Auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/register")
    public ResponseEntity<TokenResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
