package com.alejandroct.taskerdone.Controller;

import com.alejandroct.taskerdone.Service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;
}
