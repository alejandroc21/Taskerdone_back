package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.service.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatusController {
    private final IStatusService statusService;
}
