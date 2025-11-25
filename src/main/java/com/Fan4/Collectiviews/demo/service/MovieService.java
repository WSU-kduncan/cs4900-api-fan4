package com.Fan4.Collectiviews.demo.service;

import com.Fan4.Collectiviews.demo.dto.MovieDto;
import com.Fan4.Collectiviews.demo.mapper.MovieDtoMapper;
import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.repository.MovieRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

  private final MovieRepository movieRepository;
  private final MovieDtoMapper movieDtoMapper;

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovieById(Integer id) throws EntityNotFoundException {
    Optional<Movie> result = movieRepository.findById(id);
    if (result.isEmpty()) {
      throw new EntityNotFoundException("Movie (" + id + ") not found");
    }
    return result.get();
  }

  public List<Movie> getMovieByTitle(String title) throws EntityNotFoundException {
    return movieRepository.findByTitleContainingIgnoreCase(title);
  }

  @Transactional
  public Movie createNewMovie(Movie movie) throws EntityExistsException {
    try {
      return movieRepository.saveAndFlush(movie);
    } catch (DataIntegrityViolationException e) {
      throw new EntityExistsException(movie.getTitle() + " already exists");
    }
  }

  public Movie updateMovie(Integer id, MovieDto movieDto) throws EntityNotFoundException {
    Movie movie = movieRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Movie " + id + " not found"));

    if (movieDto.getTitle() != null) {
      movie.setTitle(movieDto.getTitle());
    }
    if (movieDto.getDirector() != null) {
      movie.setDirector(movieDto.getDirector());
    }
    if (movieDto.getGenre() != null) {
      movie.setGenre(movieDto.getGenre());
    }
    if (movieDto.getReleaseDate() != null) {
      movie.setReleaseDate(movieDto.getReleaseDate());
    }

    return movieRepository.saveAndFlush(movie);
  }

  public void deleteMovie(Integer id) throws EntityNotFoundException {
    try {
      // Checks for existancec before deletion
      movieRepository
          .findById(id)
          .orElseThrow(() -> new EntityNotFoundException("Movie (" + id + ") not found"));
      movieRepository.deleteById(id);
    } catch (Exception e) {
      throw new EntityNotFoundException("Provided Movie does not exist");
    }
  }
}
