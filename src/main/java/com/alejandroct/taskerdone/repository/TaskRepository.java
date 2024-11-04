package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}