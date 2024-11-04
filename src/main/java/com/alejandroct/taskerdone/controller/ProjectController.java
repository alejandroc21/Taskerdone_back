package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.dto.ProjectDTO;
import com.alejandroct.taskerdone.service.IProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final IProjectService projectService;

    @GetMapping("/list")
    public ResponseEntity<List<ProjectDTO>> listByUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth){
        return ResponseEntity.ok(projectService.listByUser(auth));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProjectDTO> findById(@PathVariable long id){
        return ResponseEntity.ok(projectService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> create(@RequestHeader(HttpHeaders.AUTHORIZATION)String auth,
                                             @Valid @RequestBody ProjectDTO request){
        return ResponseEntity.ok(projectService.create(auth, request));
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDTO> update(@RequestHeader(HttpHeaders.AUTHORIZATION)String auth,
                                             @Valid @RequestBody ProjectDTO request){
        return ResponseEntity.ok(projectService.update(auth, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(projectService.delete(id));
    }
}
