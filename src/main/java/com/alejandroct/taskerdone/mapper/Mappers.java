package com.alejandroct.taskerdone.mapper;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.model.Project;
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
}
