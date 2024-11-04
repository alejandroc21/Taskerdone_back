package com.alejandroct.taskerdone.dto;

import com.alejandroct.taskerdone.model.OrderManager;
import jakarta.validation.constraints.NotBlank;

public record ProjectDTO(
        long id,
        @NotBlank(message = "Project name is missing")
        String name,
        OrderManager orderManager
) {
}
