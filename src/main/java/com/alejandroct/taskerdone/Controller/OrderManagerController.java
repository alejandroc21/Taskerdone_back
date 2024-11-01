package com.alejandroct.taskerdone.Controller;

import com.alejandroct.taskerdone.Service.IOrderManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderManagerController {
    private final IOrderManagerService orderManagerService;
}
