package com.alejandroct.taskerdone.service;

import com.alejandroct.taskerdone.model.OrderManager;

import java.util.List;

public interface IOrderManagerService {
    OrderManager update(OrderManager orderManager);

    List<OrderManager> updateMultiple(List<OrderManager> orderManagers);

    OrderManager addIdToIdsList(long idOrderManager, long idToAdd, boolean addToEnd);

    OrderManager removeIdFromIdsList(long idOrderManager, long idToRemove);
}
