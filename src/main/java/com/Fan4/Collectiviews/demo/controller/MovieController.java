package com.Fan4.Collectiviews.demo.controller;

import com.Fan4.Collectiviews.demo.dto.MovieDto;
import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;
import com.Fan4.Collectiviews.demo.mapper.MovieDtoMapper;
import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;
import com.Fan4.Collectiviews.demo.service.MovieService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

  private final MovieDtoMapper movieDtoMapper;

  private final MovieService movieService;

  @GetMapping
  ResponseEntity<List<MovieDto>> getAllMovies() {
    return new ResponseEntity<>(
        movieDtoMapper.toDtoList(movieService.getAllMovies()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<MovieDto> getMovieById(@PathVariable Integer id) {
    return new ResponseEntity<>(movieDtoMapper.toDto(movieService.getMovieById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "/search/{title}")
  ResponseEntity<List<MovieDto>> getMovieByTitle(@PathVariable String title) {
    return new ResponseEntity<>(
        movieDtoMapper.toDtoList(movieService.getMovieByTitle(title)), HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<Object> postMovie(@RequestBody MovieDto movieDto) {

    try {
      Movie movie = movieDtoMapper.toEntity(movieDto);

      Movie createdMovie = movieService.createNewMovie(movie);

      MovieDto responseDto = movieDtoMapper.toDto(createdMovie);

      return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    } catch (EntityExistsException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> putMovie(@PathVariable Integer id, @RequestBody MovieDto movieDto) {
    Movie movie;
    try {
      movie = movieService.updateMovie(id, movieDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(movieDtoMapper.toDto(movie), HttpStatus.OK);
  }
}
