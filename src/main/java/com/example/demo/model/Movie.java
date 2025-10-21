package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movieID", nullable = false)
  Integer movieID;

  @Column(name = "title", length = 100, nullable = false)
  String title;
  
  @Column(name = "director", length = 50)
  String director;

  @Column(name = "genre", length = 30)
  String genre;

  @Column(name = "releaseDate", nullable = false)
  LocalDate releaseDate;

  @OneToMany(mappedBy = "id.movie")
  List<Review> reviews;

  @OneToMany(mappedBy = "id.movie")
  List<WatchedMovie> watchedMovies;
}
