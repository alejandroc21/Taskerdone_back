package com.alejandroct.taskerdone.Service.impl;

import com.alejandroct.taskerdone.Repository.OrderManagerRepository;
import com.alejandroct.taskerdone.Service.IOrderManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderManagerService implements IOrderManagerService {
    private final OrderManagerRepository orderManagerRepository;
}
