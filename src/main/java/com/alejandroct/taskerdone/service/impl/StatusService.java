package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.dto.StatusDTO;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.model.Project;
import com.alejandroct.taskerdone.model.Status;
import com.alejandroct.taskerdone.repository.ProjectRepository;
import com.alejandroct.taskerdone.repository.StatusRepository;
import com.alejandroct.taskerdone.service.IOrderManagerService;
import com.alejandroct.taskerdone.service.IProjectService;
import com.alejandroct.taskerdone.service.IStatusService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusService implements IStatusService {
    private final StatusRepository statusRepository;
    private final IProjectService projectService;
    private final ProjectRepository projectRepository;
    private final IOrderManagerService orderManagerService;

    @Override
    public List<StatusDTO> listByProjectId(long id) {
        return statusRepository.findByProjectId(id).stream()
                .map(Mappers::getStatusDTO).collect(Collectors.toList());
    }

    @Override
    public StatusDTO findById(long id) {
        Optional<Status> optional = statusRepository.findById(id);
        if (optional.isEmpty()){
            throw new EntityNotFoundException("Status not found");
        }
        return Mappers.getStatusDTO(optional.get());
    }

    @Override
    public StatusDTO create(StatusDTO statusDTO) {
        ProjectDTO projectDTO = projectService.findById(statusDTO.project().id());
        Project project = new Project();
        project.setId(projectDTO.id());

        Status status = new Status();
        status.setName(statusDTO.name());
        status.setOrderManager(new OrderManager());
        status.setProject(project);

        Status response = statusRepository.save(status);
        orderManagerService.addIdToIdsList(projectDTO.orderManager().getId(), response.getId(), true);

        return Mappers.getStatusDTO(response);
    }

    @Override
    public List<StatusDTO> createMultiple(List<StatusDTO> statusDTOList) {
        Project project = statusDTOList.stream().map(
                statusDTO -> projectRepository.findById(statusDTO.project().id()))
                .filter(Optional::isPresent).findFirst().map(Optional::get).orElse(null);

        List<Status> statuses = statusDTOList.stream().map(statusDTO ->{
            Status status = new Status();
            status.setName(statusDTO.name());
            status.setOrderManager(new OrderManager());
            status.setProject(project);
            return status;
        }).collect(Collectors.toList());

        List<Status> response = (List<Status>) statusRepository.saveAll(statuses);

        String idList = response.stream().map(status ->String.valueOf(status.getId())).collect(Collectors.joining(","));
        orderManagerService.update(new OrderManager(project.getOrderManager().getId(),idList));
        return response.stream().map(Mappers::getStatusDTO).collect(Collectors.toList());
    }

    @Override
    public StatusDTO update(StatusDTO statusDTO) {
        Optional<Status> optional = statusRepository.findById(statusDTO.id());
        if (optional.isEmpty()){
            throw new EntityNotFoundException("Status not found");
        }
        Status status = optional.get();
        status.setName(statusDTO.name());
        return Mappers.getStatusDTO(statusRepository.save(status));
    }

    @Override
    public String delete(long id) {
        ProjectDTO projectDTO = projectService.findById(this.findById(id).project().id());
        statusRepository.deleteById(id);
        orderManagerService.removeIdFromIdsList(projectDTO.orderManager().getId(), id);
        return "Status deleted";
    }
}
