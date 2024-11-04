package com.alejandroct.taskerdone.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Task name is missing")
    private String name;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @ManyToOne(targetEntity = Status.class)
    private Status status;
}
