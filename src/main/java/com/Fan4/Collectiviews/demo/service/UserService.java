package com.Fan4.Collectiviews.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    // Interface to repository
    private UserRepository userRepository;

    /* Business Logic Methods */

    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
