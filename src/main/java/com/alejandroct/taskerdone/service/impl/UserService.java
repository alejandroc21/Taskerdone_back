package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.repository.UserRepository;
import com.alejandroct.taskerdone.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
