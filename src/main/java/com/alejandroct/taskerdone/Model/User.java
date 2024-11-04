package com.alejandroct.taskerdone.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name can't be empty")
    @Column(nullable = false)
    private String name;

    @Email(message = "you need a valid email format")
    @NotBlank(message = "email can't be empty")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "password can't be empty")
    @Column(nullable = false)
    private String password;

    @OneToMany(targetEntity = Project.class, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Project> projects;
}
