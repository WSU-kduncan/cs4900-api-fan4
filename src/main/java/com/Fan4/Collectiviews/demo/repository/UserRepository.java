package com.Fan4.Collectiviews.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Fan4.Collectiviews.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {}
