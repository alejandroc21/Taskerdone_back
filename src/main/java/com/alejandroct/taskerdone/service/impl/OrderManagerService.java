package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.repository.OrderManagerRepository;
import com.alejandroct.taskerdone.service.IOrderManagerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderManagerService implements IOrderManagerService {
    private final OrderManagerRepository orderManagerRepository;

    @Override
    public OrderManager update(OrderManager orderManager) {
        Optional<OrderManager> manager = orderManagerRepository.findById(orderManager.getId());
        if (manager.isEmpty()){
            throw new EntityNotFoundException("OrderManager not found");
        }
        return orderManagerRepository.save(orderManager);
    }

    @Transactional
    @Override
    public List<OrderManager> updateMultiple(List<OrderManager> orderManagers) {
        List<Long> ids = orderManagers.stream().map(OrderManager::getId)
                .collect(Collectors.toList());

        List<OrderManager> existing = (List<OrderManager>) orderManagerRepository.findAllById(ids);
        if(ids.size()!=existing.size()){
            throw new EntityNotFoundException("The list of OrderManager is not complete");
        }

        return (List<OrderManager>) orderManagerRepository.saveAll(orderManagers);
    }

    /**
     * Add the id at the orderManager idsList.
     * @param idOrderManager
     * @param idToAdd
     * @return orderManager
     */
    public OrderManager addIdToIdsList(long idOrderManager, long idToAdd, boolean addToEnd){
        Optional<OrderManager> optional = orderManagerRepository.findById(idOrderManager);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("OrderManager not found");
        }
        String idsList = optional.get().getIdsList();
        OrderManager response = optional.get();

        if(idsList.isBlank()){
            response.setIdsList(String.valueOf(idToAdd));
        }else{
            response.setIdsList(addToEnd ? idsList+","+idToAdd : idToAdd+","+idsList);
        }
        return orderManagerRepository.save(response);
    }

    /**
     * Find the id in orderManager idList and remove it.
     * @param idOrderManager
     * @param idToRemove
     * @return orderManager
     */
    public OrderManager removeIdFromIdsList(long idOrderManager, long idToRemove){
        Optional<OrderManager> optional = orderManagerRepository.findById(idOrderManager);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("OrderManager not found");
        }
        String idsList = Arrays.stream(optional.get().getIdsList().split(","))
                .filter(id -> !id.equals(String.valueOf(idToRemove)))
                .collect(Collectors.joining(","));
        return orderManagerRepository.save(new OrderManager(optional.get().getId(),idsList));
    }
}
