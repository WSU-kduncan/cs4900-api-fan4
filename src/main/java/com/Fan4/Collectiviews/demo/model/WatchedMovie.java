package com.Fan4.Collectiviews.demo.model;

import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "watchedMovie")
public class WatchedMovie {

  @EmbeddedId
  WatchedMovieId id;

  @Column(name = "watchedDate", nullable = false)
  LocalDate watchedDate; // Best Date class?
}
