package com.alejandroct.taskerdone.Service.impl;

import com.alejandroct.taskerdone.Repository.StatusRepository;
import com.alejandroct.taskerdone.Service.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService implements IStatusService {
    private final StatusRepository statusRepository;
}
