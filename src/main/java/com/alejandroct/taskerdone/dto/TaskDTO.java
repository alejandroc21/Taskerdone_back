package com.alejandroct.taskerdone.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskDTO(
        long id,
        @NotBlank(message = "Task name is missing")
        String name,
        StatusDTO status,
        ProjectDTO project
) {
}
