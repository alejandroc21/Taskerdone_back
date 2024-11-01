package com.alejandroct.taskerdone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(targetEntity = Project.class)
    private Project project;

    @OneToMany(targetEntity = Task.class, fetch = FetchType.LAZY, mappedBy = "status")
    private List<Task> tasks;

    @OneToOne(targetEntity = OrderManager.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private OrderManager orderManager;
}
