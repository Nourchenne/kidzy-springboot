package com.example.kidzy.controller;

import com.example.kidzy.entity.Babysitter;
import com.example.kidzy.service.BabysitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babysitters")
public class BabysitterController {

    @Autowired
    private BabysitterService babysitterService;

    @GetMapping
    public List<Babysitter> getAllBabysitters() {
        return babysitterService.getAllBabysitters();
    }


    @PostMapping
    public Babysitter addBabysitter(@RequestBody Babysitter babysitter) {
        return babysitterService.addBabysitter(babysitter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBabysitter(@PathVariable Integer id) {
        boolean deleted = babysitterService.deleteBabysitter(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
