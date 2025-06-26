package com.example.kidzy.service;

import com.example.kidzy.entity.Parent;
import com.example.kidzy.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    @Autowired
    private ParentsRepository parentRepository;

    // Récupérer tous les parents
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    // Récupérer un parent par id
    public Optional<Parent> getParentById(Integer id) {
        return parentRepository.findById(id);
    }

    // Ajouter un parent
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    // Supprimer un parent par id
    public boolean deleteParent(Integer id) {
        if (parentRepository.existsById(id)) {
            parentRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Optional<Parent> findByEmail(String email) {
        return parentRepository.findByEmail(email);
    }
}
