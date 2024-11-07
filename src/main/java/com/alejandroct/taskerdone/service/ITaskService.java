package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.dto.request.UpdateTaskStatusRequest;
import com.alejandroct.taskerdone.model.Task;

import java.util.List;

public interface ITaskService {

    List<TaskDTO> listByProject(long id);

    TaskDTO create(TaskDTO taskDTO);

    TaskDTO update(TaskDTO taskDTO);

    String delete(long id);

    TaskDTO findById(long id);

    TaskDTO UpdateTaskStatus(UpdateTaskStatusRequest request);
}
