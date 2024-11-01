package com.alejandroct.taskerdone.Service.impl;

import com.alejandroct.taskerdone.Repository.UserRepository;
import com.alejandroct.taskerdone.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
}
