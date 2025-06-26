package com.example.kidzy.service;


import com.example.kidzy.entity.BabysittingRequest;
import com.example.kidzy.repository.BabysittingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BabysittingRequestService {



    @Autowired
    private BabysittingRequestRepository repository;

    public BabysittingRequest getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<BabysittingRequest> getAll() {
        return repository.findAll();
    }

    public BabysittingRequest add(BabysittingRequest request) {
        return repository.save(request);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


    public List<BabysittingRequest> getAllRequests() {
        return repository.findAll();
    }
}
