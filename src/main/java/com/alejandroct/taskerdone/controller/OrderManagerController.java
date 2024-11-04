package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.service.IOrderManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_manager")
@RequiredArgsConstructor
public class OrderManagerController {
    private final IOrderManagerService orderManagerService;
}
