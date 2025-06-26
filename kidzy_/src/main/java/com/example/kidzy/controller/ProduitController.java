package com.example.kidzy.controller;

import com.example.kidzy.entity.Produit;
import com.example.kidzy.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable Integer id) {
        return produitService.getById(id);
    }

    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.add(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Integer id, @RequestBody Produit produit) {
        return produitService.update(id, produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Integer id) {
        produitService.delete(id);
    }
}
