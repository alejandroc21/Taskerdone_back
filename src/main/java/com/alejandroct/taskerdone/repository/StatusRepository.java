package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
    List<Status> findByProjectId(long id);
}
