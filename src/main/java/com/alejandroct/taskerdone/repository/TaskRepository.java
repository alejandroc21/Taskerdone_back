package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByProjectId(long id);
}
