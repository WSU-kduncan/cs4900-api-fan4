package com.example.demo.model;

import java.time.LocalDate;
import com.example.demo.model.composite.watchedMovieId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "watchedMovie")
public class watchedMovie {

    @EmbeddedId
    watchedMovieId id;

    @Column(name = "watchedDate", nullable = false)
    LocalDate watchedDate;
}