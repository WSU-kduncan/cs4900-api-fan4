package com.Fan4.Collectiviews.demo.controller;

import com.Fan4.Collectiviews.demo.dto.MovieDto;
import com.Fan4.Collectiviews.demo.mapper.MovieDtoMapper;
import com.Fan4.Collectiviews.demo.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "movie",
    produces = MediaType.APPLICATION_JSON_VALUE)
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
        return new ResponseEntity<>(
            movieDtoMapper.toDto(movieService.getMovieById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "/search/{title}")
    ResponseEntity<List<MovieDto>> getMovieByTitle(@PathVariable String title) {
        return new ResponseEntity<>(
            movieDtoMapper.toDtoList(movieService.getMovieByTitle(title)), HttpStatus.OK);
    }
}
