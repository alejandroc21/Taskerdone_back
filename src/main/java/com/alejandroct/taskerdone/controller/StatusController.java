package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.dto.StatusDTO;
import com.alejandroct.taskerdone.service.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {
    private final IStatusService statusService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<StatusDTO>> listByProjectId(@PathVariable long id){
        return ResponseEntity.ok(statusService.listByProjectId(id));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StatusDTO> findById(@PathVariable long id){
        return ResponseEntity.ok(statusService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@RequestBody StatusDTO statusDTO){
        return ResponseEntity.ok(statusService.create(statusDTO));
    }

    @PostMapping("/create_multiple")
    public ResponseEntity<List<StatusDTO>> createMultiple(@RequestBody List<StatusDTO> statusDTOList){
        return ResponseEntity.ok(statusService.createMultiple(statusDTOList));
    }

    @PutMapping("/update")
    public ResponseEntity<StatusDTO> update(@RequestBody StatusDTO statusDTO){
        return ResponseEntity.ok(statusService.update(statusDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(statusService.delete(id));
    }
}
