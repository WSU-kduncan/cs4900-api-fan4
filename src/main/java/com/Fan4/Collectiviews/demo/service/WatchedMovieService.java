package com.Fan4.Collectiviews.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.repository.WatchedMovieRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WatchedMovieService {

  private final WatchedMovieRepository watchedMovieRepository;

  public List<WatchedMovie> getAllWatchedMovies() {
    return watchedMovieRepository.findAll();
  }

  public Optional<WatchedMovie> getWatchedMovieById(Integer id) throws EntityNotFoundException{
    Optional<WatchedMovie> result = watchedMovieRepository.findById(id);
    if (result.isPresent() && result.isEmpty()){
        throw new EntityNotFoundException("No watched movie entry corresponding to " + id);
    }
    return watchedMovieRepository.findById(id);
  }

  public List<WatchedMovie> getWatchedMoviesByUsername(String username) throws EntityNotFoundException{
    return watchedMovieRepository.findByUsername(username);
  }
}