package com.alejandroct.taskerdone.Controller;

import com.alejandroct.taskerdone.Service.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatusController {
    private final IStatusService statusService;
}
