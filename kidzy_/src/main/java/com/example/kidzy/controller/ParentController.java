package com.example.kidzy.controller;

import com.example.kidzy.entity.Parent;
import com.example.kidzy.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parents")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Integer id) {
        return parentService.getParentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Parent addParent(@RequestBody Parent parent) {
        return parentService.addParent(parent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Integer id) {
        boolean deleted = parentService.deleteParent(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/form")
    public ResponseEntity<String> addParentFromForm(
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam String mdp,
            @RequestParam String num,
            @RequestParam String adresse,
            @RequestParam(name = "num_enfant") int numEnfant) {

        Parent parent = new Parent();
        parent.setNom(nom);
        parent.setEmail(email);
        parent.setMdp(mdp);
        parent.setNum(num);
        parent.setAdresse(adresse);
        parent.setNumEnfant(numEnfant);

        parentService.addParent(parent);

        return ResponseEntity.ok("Parent ajouté avec succès !");
    }

}
