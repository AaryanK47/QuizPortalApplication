package com.example.QuizPortalApplication.service;

import com.example.QuizPortalApplication.entity.User;
import com.example.QuizPortalApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    // Register User
    public User register(User user) {

        Optional<User> existing = repository.findByEmail(user.getEmail());

        if (existing.isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        return repository.save(user);
    }

    // Login User
    public User login(String email, String password) {

        return repository.findByEmailAndPassword(email, password)
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email or Password"));
    }
}