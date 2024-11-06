package com.alejandroct.taskerdone.dto;

import com.alejandroct.taskerdone.model.OrderManager;
import jakarta.validation.constraints.NotBlank;

public record StatusDTO(
        long id,
        @NotBlank(message = "Status name is missing")
        String name,
        OrderManager orderManager,
        @NotBlank(message = "Project is empty")
        ProjectDTO project
) {
}
