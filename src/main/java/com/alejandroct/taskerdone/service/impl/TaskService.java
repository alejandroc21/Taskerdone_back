package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.dto.StatusDTO;
import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.dto.request.UpdateTaskStatusRequest;
import com.alejandroct.taskerdone.mapper.Mappers;
import com.alejandroct.taskerdone.model.Task;
import com.alejandroct.taskerdone.repository.TaskRepository;
import com.alejandroct.taskerdone.service.IOrderManagerService;
import com.alejandroct.taskerdone.service.IStatusService;
import com.alejandroct.taskerdone.service.ITaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final IStatusService statusService;
    private final IOrderManagerService orderManagerService;

    @Override
    public List<TaskDTO> listByProject(long id) {
        return taskRepository.findByProjectId(id).stream().map(Mappers::getTaskDTO).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(long id) {
        return Mappers.getTaskDTO(this.findTaskById(id));
    }

    /**
     * Updates the task status and the input and output orderManagers
     * @param request
     * @return TaskDTO
     */
    @Transactional
    @Override
    public TaskDTO UpdateTaskStatus(UpdateTaskStatusRequest request) {
        if(request.orderManagerList().size() != 2){
            throw new IllegalArgumentException("There should be two OrderManager to work");
        }
        Task task = this.findTaskById(request.taskDTO().id());
        task.setStatus(Mappers.getStatus(request.taskDTO().status()));
        orderManagerService.updateMultiple(request.orderManagerList());

        return Mappers.getTaskDTO(taskRepository.save(task));
    }

    /**
     * Create the Task and adds the id at the orderManager idsList.
     * @param taskDTO
     * @return taskDTO
     */
    @Transactional
    @Override
    public TaskDTO create(TaskDTO taskDTO) {
        StatusDTO statusDTO = statusService.findById(taskDTO.status().id());
        Task task = taskRepository.save(Mappers.getTask(taskDTO));
        orderManagerService.addIdToIdsList(statusDTO.orderManager().getId(),task.getId(), false);
        return Mappers.getTaskDTO(task);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        Task task = this.findTaskById(taskDTO.id());
        task.setName(taskDTO.name());
        return Mappers.getTaskDTO(taskRepository.save(task));
    }

    /**
     * Delete the Status and remove its id at the orderManager idsList.
     * @param id
     * @return String
     */
    @Transactional
    @Override
    public String delete(long id) {
        TaskDTO taskDTO = this.findById(id);
        StatusDTO statusDTO = statusService.findById(taskDTO.status().id());
        orderManagerService.removeIdFromIdsList(statusDTO.orderManager().getId(), taskDTO.id());
        return "deleted";
    }


    private Task findTaskById(long id){
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isEmpty()){
            throw new EntityNotFoundException("Task not found");
        }
        return optional.get();
    }


}
