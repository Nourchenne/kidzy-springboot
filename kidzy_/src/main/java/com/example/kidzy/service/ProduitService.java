package com.example.kidzy.service;

import com.example.kidzy.entity.Produit;
import com.example.kidzy.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    public Produit getById(Integer id) {
        return produitRepository.findById(id).orElse(null);
    }

    public Produit add(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit update(Integer id, Produit produit) {
        return produitRepository.findById(id).map(existingProduit -> {
            existingProduit.setNom(produit.getNom());
            existingProduit.setPrix(produit.getPrix());
            existingProduit.setDescription(produit.getDescription());
            existingProduit.setPhoto(produit.getPhoto());
            return produitRepository.save(existingProduit);
        }).orElse(null);
    }

    public void delete(Integer id) {
        produitRepository.deleteById(id);
    }
}
