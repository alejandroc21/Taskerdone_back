package com.alejandroct.taskerdone.dto.request;

import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.model.OrderManager;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UpdateTaskStatusRequest(
        @NotBlank(message = "Task is missing")
        TaskDTO taskDTO,
        @NotBlank(message = "OrderManagerList is missing")
        List<OrderManager> orderManagerList
) {
}
