package com.alejandroct.taskerdone.controller;

import com.alejandroct.taskerdone.model.OrderManager;
import com.alejandroct.taskerdone.service.IOrderManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderManagerController {
    private final IOrderManagerService orderManagerService;

    @PutMapping("/update")
    public ResponseEntity<OrderManager> update(@RequestBody OrderManager orderManager){
        return ResponseEntity.ok(orderManagerService.update(orderManager));
    }

    @PutMapping("/update_multiple")
    public ResponseEntity<List<OrderManager>> updateMultiple(@RequestBody List<OrderManager> orderManagers){
        return ResponseEntity.ok(orderManagerService.updateMultiple(orderManagers));
    }
}
