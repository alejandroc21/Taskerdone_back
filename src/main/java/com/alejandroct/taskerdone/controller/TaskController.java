package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;
}
