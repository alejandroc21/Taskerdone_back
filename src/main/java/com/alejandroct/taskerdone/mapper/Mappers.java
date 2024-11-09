package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.StatusDTO;
import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.model.*;

public class Mappers {

    public static ProjectDTO getProjectDTO(Project project){
        return new ProjectDTO(project.getId(), project.getName(), project.getOrderManager());
    }

    public static Project getProject(ProjectDTO projectDTO, OrderManager orderManager, User user){
        Project project = new Project();
        project.setId(projectDTO.id());
        project.setName(projectDTO.name());
        project.setOrderManager(orderManager);
        project.setUser(user);
        return project;
    }

    public static StatusDTO getStatusDTO(Status status){
        return new StatusDTO(status.getId(),status.getName(), status.getOrderManager(), getProjectDTO(status.getProject()));
    }

    public static Status getStatus(StatusDTO statusDTO){
        Status status = new Status();
        Project project = new Project();
        project.setId(status.getId());
        status.setId(statusDTO.id());
        status.setName(statusDTO.name());
        status.setProject(project);
        status.setOrderManager(statusDTO.orderManager());
        return status;
    }

    public static TaskDTO getTaskDTO(Task task){
        return new TaskDTO(task.getId(), task.getName(), Mappers.getStatusDTO(task.getStatus()), Mappers.getProjectDTO(task.getProject()));
    }

    public static Task getTask(TaskDTO taskDTO){
        Task task = new Task();
        Project project = new Project();
        project.setId(taskDTO.project().id());
        task.setId(taskDTO.id());
        task.setName(taskDTO.name());
        task.setStatus(Mappers.getStatus(taskDTO.status()));
        task.setProject(project);
        return task;
    }
}
