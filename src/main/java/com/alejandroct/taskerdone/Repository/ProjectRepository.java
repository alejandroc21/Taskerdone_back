package com.alejandroct.taskerdone.Repository;

import com.alejandroct.taskerdone.Model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
