package com.alejandroct.taskerdone.Service.impl;

import com.alejandroct.taskerdone.Repository.TaskRepository;
import com.alejandroct.taskerdone.Service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;

}
