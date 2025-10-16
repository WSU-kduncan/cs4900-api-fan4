package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "movie")
public class Movie {

  @Id
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
}
