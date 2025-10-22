package com.Fan4.Collectiviews.demo.repository;

import com.Fan4.Collectiviews.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  // Need to define findAll() signature here?
  // Constructor issue?
}
