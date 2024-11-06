package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.StatusDTO;
import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.model.Project;
import com.alejandroct.taskerdone.model.Status;
import com.alejandroct.taskerdone.model.User;

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
}
