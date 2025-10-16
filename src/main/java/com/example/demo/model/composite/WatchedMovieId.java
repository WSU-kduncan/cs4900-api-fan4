package com.example.demo.model.composite;

import java.io.Serializable;

import com.example.demo.model.Movie;
import com.example.demo.model.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class WatchedMovieId implements Serializable {

  @JoinColumn(name = "username", nullable = false)
  @ManyToOne
  User user;

  @JoinColumn(name = "movieID", nullable = false)
  @ManyToOne
  Movie movie;
}
