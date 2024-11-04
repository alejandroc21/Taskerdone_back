package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.ProjectDTO;

import java.util.List;

public interface IProjectService {
    List<ProjectDTO> listByUser(String auth);

    ProjectDTO create(String auth, ProjectDTO request);

    ProjectDTO findById(long id);

    ProjectDTO update(String auth, ProjectDTO request);

    String delete(long id);
}
