package com.example.kidzy.repository;

import com.example.kidzy.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParentsRepository extends JpaRepository<Parent, Integer> {
    Optional<Parent> findByEmail(String email);
}
