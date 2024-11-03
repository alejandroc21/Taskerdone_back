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

    @Column(nullable = false)
    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "password can't be empty")
    private String password;

    @Email(message = "you need a valid email format")
    @Column(unique = true, nullable = false)
    @NotBlank(message = "email can't be empty")
    private String email;

    @OneToMany(targetEntity = Project.class, fetch = FetchType.LAZY,mappedBy = "user")
    private List<Project> projects;
}
