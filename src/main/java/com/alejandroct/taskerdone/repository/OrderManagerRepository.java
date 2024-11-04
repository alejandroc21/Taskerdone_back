package com.alejandroct.taskerdone.repository;

import com.alejandroct.taskerdone.model.OrderManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderManagerRepository extends CrudRepository<OrderManager, Long> {
}
