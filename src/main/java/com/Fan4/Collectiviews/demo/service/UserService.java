package com.Fan4.Collectiviews.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    // Interface to repository
    private UserRepository userRepository;

    /* Business Logic Methods */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String username) {
        return userRepository
            .findById(username)
            .orElseThrow(() -> new EntityNotFoundException("User (" + username + ") not found"));
    }
    
}
