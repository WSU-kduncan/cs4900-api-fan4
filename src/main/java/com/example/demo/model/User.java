package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name = "username", length = 30, nullable = false)
  String username;

  @Column(name = "name", length = 50)
  String name;

  @Column(name = "password_hash", length = 30, nullable = false)
  String passwordHash;

  @Column(name = "birthDate", nullable = false)
  LocalDate birthDate;

  @OneToMany(mappedBy = "id.user")
  List<Review> reviews;

  @OneToMany(mappedBy = "id.user")
  List<WatchedMovie> watchedMovies;
}
