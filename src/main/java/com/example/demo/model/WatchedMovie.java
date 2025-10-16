package com.example.demo.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.model.composite.WatchedMovieId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "watchedMovie")
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
  @CreationTimestamp
  Instant watchedDate; // May be a good idea...
}
