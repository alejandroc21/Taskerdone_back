package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
}
