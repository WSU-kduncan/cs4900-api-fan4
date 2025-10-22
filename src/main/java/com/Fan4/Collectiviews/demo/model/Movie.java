package com.Fan4.Collectiviews.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "movieID", nullable = false)
  Integer movieID;

  @Column(name = "title", length = 100, nullable = false)
  String title;

  @Column(name = "director", length = 50, nullable = true)
  String director;

  @Column(name = "genre", length = 30, nullable = true)
  String genre;

  @Column(name = "releaseDate", nullable = false)
  LocalDate releaseDate;
}
