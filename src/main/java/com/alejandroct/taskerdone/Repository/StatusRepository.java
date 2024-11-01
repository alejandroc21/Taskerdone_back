package com.alejandroct.taskerdone.Repository;

import com.alejandroct.taskerdone.Model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
