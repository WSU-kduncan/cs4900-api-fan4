package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movie")
public class Movie {
    
    @Id
    @Column(name = "movieID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
