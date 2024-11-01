package com.alejandroct.taskerdone.Repository;

import com.alejandroct.taskerdone.Model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
