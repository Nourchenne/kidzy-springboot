package com.example.kidzy.service;

import com.example.kidzy.entity.LoginRequest;
import com.example.kidzy.entity.Babysitter;
import com.example.kidzy.entity.Parent;
import com.example.kidzy.repository.BabysitterRepository;
import com.example.kidzy.repository.ParentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private ParentsRepository parentRepository;

    @Autowired
    private BabysitterRepository babysitterRepository;

    public String login(LoginRequest request) {
        Optional<Parent> parentOpt = parentRepository.findByEmail(request.getEmail());
        if (parentOpt.isPresent() && parentOpt.get().getMdp().equals(request.getMdp())) {
            return "parent";
        }

        Optional<Babysitter> babyOpt = babysitterRepository.findByEmail(request.getEmail());
        if (babyOpt.isPresent() && babyOpt.get().getMdp().equals(request.getMdp())) {
            return "babysitter";
        }

        return "invalid";
    }
}
