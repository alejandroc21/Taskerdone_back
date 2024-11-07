package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.dto.TaskDTO;
import com.alejandroct.taskerdone.dto.request.UpdateTaskStatusRequest;
import com.alejandroct.taskerdone.model.Task;
import com.alejandroct.taskerdone.service.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<TaskDTO>> listByProject(@PathVariable long id){
        return ResponseEntity.ok(taskService.listByProject(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable long id){
        return  ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.create(taskDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(taskService.update(taskDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(taskService.delete(id));
    }

    @PutMapping("update_status")
    public ResponseEntity<TaskDTO> updateTaskStatus(@Valid @RequestBody UpdateTaskStatusRequest request){
        return ResponseEntity.ok(taskService.UpdateTaskStatus(request));
    }
}
