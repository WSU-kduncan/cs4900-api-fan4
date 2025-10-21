package com.Fan4.Collectiviews.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fan4.Collectiviews.demo.model.WatchedMovie;

@Repository
public interface WatchedMovieRepository extends JpaRepository<WatchedMovie, Integer> {

  List<WatchedMovie> findById();

  List<WatchedMovie> findByUsername(String username);
}