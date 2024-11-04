package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.OrderManagerRepository;
import com.alejandroct.taskerdone.service.IOrderManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderManagerService implements IOrderManagerService {
    private final OrderManagerRepository orderManagerRepository;
}
