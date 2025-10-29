package com.Fan4.Collectiviews.demo.model;

import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table
public class WatchedMovie {

  @EmbeddedId
  WatchedMovieId id;

  @MapsId("username")
  @ManyToOne
  @JoinColumn(name = "username", nullable = false)
  User user;

  @MapsId("movieID")
  @ManyToOne
  @JoinColumn(name = "movieID", nullable = false)
  Movie movie;

  @Column(name = "watchedDate", nullable = false)
  LocalDate watchedDate; // Best Date class?
}
