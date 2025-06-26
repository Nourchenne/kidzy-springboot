package com.example.kidzy.controller;

import com.example.kidzy.entity.Babysitter;
import com.example.kidzy.entity.Parent;
import com.example.kidzy.service.BabysitterService;
import com.example.kidzy.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private ParentService parentService;

    @Autowired
    private BabysitterService babysitterService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return ResponseEntity.badRequest().body("Email et mot de passe sont requis.");
        }

        // Vérifier chez les parents
        Parent parent = parentService.findByEmail(email).orElse(null);
        if (parent != null && parent.getMdp().equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("role", "parent");
            response.put("id", String.valueOf(parent.getId()));
            return ResponseEntity.ok(response);
        }

        // Vérifier chez les babysitters
        Babysitter babysitter = babysitterService.findByEmail(email).orElse(null);
        if (babysitter != null && babysitter.getMdp().equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("role", "babysitter");
            response.put("id", String.valueOf(babysitter.getId()));
            return ResponseEntity.ok(response);
        }

        // Aucun match
        return ResponseEntity.status(401).body("Email ou mot de passe invalide.");
    }
}
