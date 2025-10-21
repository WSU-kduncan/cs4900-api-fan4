package com.Fan4.Collectiviews.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fan4.Collectiviews.demo.mapper.WatchedMovieDtoMapper;
import com.Fan4.Collectiviews.demo.service.WatchedMovieService;
import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "watched-movie",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE // need both of these?
)
public class WatchedMovieController {
    
    private final WatchedMovieDtoMapper watchedMovieDtoMapper;

    private final WatchedMovieService watchedMovieService;

    @GetMapping
    ResponseEntity<List<WatchedMovieDto>> getAllWatchedMovies() {
        return new ResponseEntity<>(
            watchedMovieDtoMapper.toDtoList(watchedMovieService.getAllWatchedMovies()), HttpStatus.OK
        );
    }


    @GetMapping(path = "{id}") // Composite key question
    ResponseEntity<WatchedMovieDto> getWatchedMoviesById(@PathVariable Integer id) {
        return new ResponseEntity<>(
            watchedMovieDtoMapper.toDto(watchedMovieService.getWatchedMovieById(id)), HttpStatus.OK
        );
    }

    @GetMapping(path = "/search/{username}")
    ResponseEntity<List<WatchedMovieDto>> getWatchedMoviesByUsername(@PathVariable String username) {
        return new ResponseEntity<>(
            watchedMovieDtoMapper.toDtoList(watchedMovieService.getWatchedMoviesByUsername(username)), HttpStatus.OK
        );
    }
}
