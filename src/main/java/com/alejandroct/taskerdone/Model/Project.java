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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(targetEntity = Task.class, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Task> tasks;

    @OneToMany(targetEntity = Status.class, fetch = FetchType.LAZY, mappedBy = "project")
    private List<Status> statuses;

    @OneToOne(targetEntity = OrderManager.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private OrderManager orderManager;

    @ManyToOne(targetEntity = User.class)
    private User user;

}
