package com.alejandroct.taskerdone.Controller;

import com.alejandroct.taskerdone.Service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService projectService;
}
