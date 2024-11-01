package com.alejandroct.taskerdone.Repository;

import com.alejandroct.taskerdone.Model.OrderManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderManagerRepository extends CrudRepository<OrderManager, Long> {
}
