package com.alejandroct.taskerdone.Controller;

import com.alejandroct.taskerdone.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
}
