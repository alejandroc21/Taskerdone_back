package com.alejandroct.taskerdone.service.impl;

import com.alejandroct.taskerdone.repository.StatusRepository;
import com.alejandroct.taskerdone.service.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService implements IStatusService {
    private final StatusRepository statusRepository;
}
