package com.alejandroct.taskerdone.Service.Auth;

import com.alejandroct.taskerdone.DTO.Auth.LoginRequest;
import com.alejandroct.taskerdone.DTO.Auth.RegisterRequest;
import com.alejandroct.taskerdone.DTO.Auth.TokenResponse;
import com.alejandroct.taskerdone.Model.User;
import com.alejandroct.taskerdone.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public TokenResponse register(RegisterRequest request){
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();

        String jwtToken = jwtService.buildToken(userRepository.save(user));
        return new TokenResponse(jwtToken);
    }

    public TokenResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String jwtToken = jwtService.buildToken(userRepository.findByEmail(request.email()).orElseThrow(
                ()-> new UsernameNotFoundException("User not found")));
        return new TokenResponse(jwtToken);
    }
}
