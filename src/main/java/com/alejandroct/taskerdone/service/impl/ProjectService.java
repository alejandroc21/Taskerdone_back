package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.model.Project;
import com.alejandroct.taskerdone.model.User;
import com.alejandroct.taskerdone.repository.ProjectRepository;
import com.alejandroct.taskerdone.service.auth.JwtService;
import com.alejandroct.taskerdone.service.IProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    private final JwtService jwtService;

    @Override
    public List<ProjectDTO> listByUser(String auth) {
        return projectRepository.findByUserId(jwtService.getUserIdFromToken(auth))
                .stream().map(Mappers::getProjectDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO findById(long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()){
            throw new EntityNotFoundException("Project not found");
        }
        return Mappers.getProjectDTO(project.get());
    }

    @Override
    public ProjectDTO create(String auth, ProjectDTO request) {
        Project project = new Project();
        project.setName(request.name());
        project.setUser(new User(jwtService.getUserIdFromToken(auth)));
        project.setOrderManager(new OrderManager());

        return Mappers.getProjectDTO(projectRepository.save(project));
    }

    @Override
    public ProjectDTO update(String auth, ProjectDTO request) {
        Optional<Project> verify = projectRepository.findById(request.id());
        if (verify.isEmpty()){
            throw new EntityNotFoundException("Project not found");
        }
        Project project = Mappers.getProject(request, new OrderManager(), new User(jwtService.getUserIdFromToken(auth)));
        return Mappers.getProjectDTO(projectRepository.save(project));
    }

    @Override
    public String delete(long id) {
        projectRepository.deleteById(id);
        return "Project deleted";
    }
}
