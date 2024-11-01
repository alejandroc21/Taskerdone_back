package com.alejandroct.taskerdone.Service.impl;

import com.alejandroct.taskerdone.Repository.ProjectRepository;
import com.alejandroct.taskerdone.Service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
}
