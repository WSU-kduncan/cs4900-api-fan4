package com.Fan4.Collectiviews.demo.repository;

import com.Fan4.Collectiviews.demo.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // Search for users whose name contains the search
    // string (case-insensitive)
    List<User> findByNameContainingIgnoreCase(String name);

    // Search for exact name match
    Optional<User> findByName(String name);
}
