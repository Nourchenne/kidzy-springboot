package com.example.kidzy.service;

import com.example.kidzy.entity.Babysitter;
import com.example.kidzy.repository.BabysitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BabysitterService {

    @Autowired
    private BabysitterRepository babysitterRepository;

    public List<Babysitter> getAllBabysitters() {
        return babysitterRepository.findAll();
    }

    public Optional<Babysitter> getBabysitterById(Integer id) {
        return babysitterRepository.findById(id);
    }

    public Babysitter addBabysitter(Babysitter babysitter) {
        return babysitterRepository.save(babysitter);
    }

    public boolean deleteBabysitter(Integer id) {
        if (babysitterRepository.existsById(id)) {
            babysitterRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Optional<Babysitter> findByEmail(String email) {
        return babysitterRepository.findByEmail(email);    }
}
