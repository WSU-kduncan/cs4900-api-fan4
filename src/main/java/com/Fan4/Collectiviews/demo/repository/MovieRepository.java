package com.Fan4.Collectiviews.demo.repository;

import com.Fan4.Collectiviews.demo.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
  List<Movie> findByTitleContainingIgnoreCase(String title);
}
