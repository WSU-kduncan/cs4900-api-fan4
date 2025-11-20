package com.Fan4.Collectiviews.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;
import com.Fan4.Collectiviews.demo.mapper.WatchedMovieDtoMapper;
import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;
import com.Fan4.Collectiviews.demo.service.WatchedMovieService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "watched-movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class WatchedMovieController {

  private final WatchedMovieDtoMapper watchedMovieDtoMapper;

  private final WatchedMovieService watchedMovieService;

  @GetMapping
  ResponseEntity<List<WatchedMovieDto>> getAllWatchedMovies() {
    return new ResponseEntity<>(
        watchedMovieDtoMapper.toDtoList(watchedMovieService.getAllWatchedMovies()), HttpStatus.OK);
  }

  @GetMapping(path = "{movieId}/{username}")
  ResponseEntity<WatchedMovieDto> getWatchedMoviesById(
      @PathVariable Integer movieId, @PathVariable String username) {
    WatchedMovieId id = new WatchedMovieId();
    id.setUser(new User());
    id.getUser().setUsername(username);
    id.setMovie(new Movie());
    id.getMovie().setMovieID(movieId);

    try {
      WatchedMovie watchedMovie = watchedMovieService.getWatchedMovieById(id);
      return new ResponseEntity<>(watchedMovieDtoMapper.toDto(watchedMovie), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/by-user/{username}")
  ResponseEntity<List<WatchedMovieDto>> getWatchedMoviesByUsername(@PathVariable String username) {
    return new ResponseEntity<>(
        watchedMovieDtoMapper.toDtoList(watchedMovieService.getWatchedMoviesByUsername(username)),
        HttpStatus.OK);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> putWatchedMovie(@RequestBody WatchedMovieDto watchedMovieDto) {
    WatchedMovie watchedMovie;
    WatchedMovieId id = new WatchedMovieId();
    id.setUser(new User());
    id.getUser().setUsername(watchedMovieDto.getUser());
    id.setMovie(new Movie());
    id.getMovie().setMovieID(watchedMovieDto.getMovieID());

    try {
      watchedMovie = watchedMovieService.getWatchedMovieById(id);

      // Updating entity
      try {
        watchedMovie = watchedMovieService.createOrUpdateWatchedMovie(watchedMovieDto);
      } catch (EntityNotFoundException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<>(watchedMovieDtoMapper.toDto(watchedMovie), HttpStatus.OK);
    } catch (EntityNotFoundException e) { // Entity does not already exist

      // Creating new entity
      try {
        watchedMovie = watchedMovieService.createOrUpdateWatchedMovie(watchedMovieDto);
      } catch (EntityNotFoundException exception) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<>(
          watchedMovieDtoMapper.toDto(watchedMovie),
          HttpStatus.CREATED); // HTTP Status demonstrates new entity is created
    }
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> postWatchedMovie(@RequestBody WatchedMovieDto watchedMovieDto) {
    WatchedMovie watchedMovie;
    WatchedMovieId id = new WatchedMovieId();
    id.setUser(new User());
    id.getUser().setUsername(watchedMovieDto.getUser());
    id.setMovie(new Movie());
    id.getMovie().setMovieID(watchedMovieDto.getMovieID());

    try {
      watchedMovieService.getWatchedMovieById(id);
    } catch (EntityNotFoundException e) {
      watchedMovie = watchedMovieService.createNewWatchedMovie(watchedMovieDto);
      return new ResponseEntity<>(watchedMovieDtoMapper.toDto(watchedMovie), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }

  @DeleteMapping(path = "{movieId}/{username}")
  ResponseEntity<Object> deleteWatchedMovie(@PathVariable Integer movieId, @PathVariable String username) {

    WatchedMovieId id = new WatchedMovieId();
    id.setUser(new User());
    id.getUser().setUsername(username);
    id.setMovie(new Movie());
    id.getMovie().setMovieID(movieId);

    try {
      watchedMovieService.getWatchedMovieById(id); // Check to ensure watchedMovie exists before deleting it
      watchedMovieService.deleteWatchedMovieById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
