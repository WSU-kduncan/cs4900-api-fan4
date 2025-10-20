package com.example.demo.model;

import java.time.LocalDate;

import com.example.demo.model.composite.WatchedMovieId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "watchedMovie")
public class WatchedMovie {
    
    @EmbeddedId
    WatchedMovieId id;
    
    @Column(name = "watchedDate", nullable = false)
    LocalDate watchedDate;
}