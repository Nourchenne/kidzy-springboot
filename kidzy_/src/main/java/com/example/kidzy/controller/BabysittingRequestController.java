package com.example.kidzy.controller;

import com.example.kidzy.entity.BabysittingRequest;
import com.example.kidzy.service.BabysittingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class BabysittingRequestController {

    @Autowired
    private BabysittingRequestService service;

    @GetMapping("/{id}")
    public ResponseEntity<BabysittingRequest> getById(@PathVariable Integer id) {
        BabysittingRequest request = service.getById(id);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(request);
    }

    @GetMapping
    public List<BabysittingRequest> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BabysittingRequest addRequest(@RequestBody BabysittingRequest request) {
        return service.add(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Integer id) {
        BabysittingRequest existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
