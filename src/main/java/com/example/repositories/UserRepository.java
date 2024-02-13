package com.example.repositories;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<Object> findById(Long id);

    void deleteById(Long id);
}
