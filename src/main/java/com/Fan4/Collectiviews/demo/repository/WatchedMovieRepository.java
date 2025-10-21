package com.Fan4.Collectiviews.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;

@Repository
public interface WatchedMovieRepository extends JpaRepository<WatchedMovie, WatchedMovieId> {

  List<WatchedMovie> findByIdUserUsername(String username);
}