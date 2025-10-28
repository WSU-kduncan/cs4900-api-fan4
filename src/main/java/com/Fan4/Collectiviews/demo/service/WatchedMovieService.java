package com.Fan4.Collectiviews.demo.service;

import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;
import com.Fan4.Collectiviews.demo.mapper.WatchedMovieDtoMapper;
import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;
import com.Fan4.Collectiviews.demo.repository.WatchedMovieRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WatchedMovieService {

  private final WatchedMovieRepository watchedMovieRepository;

  private final WatchedMovieDtoMapper watchedMovieDtoMapper;

  public List<WatchedMovie> getAllWatchedMovies() {
    return watchedMovieRepository.findAll();
  }

  public WatchedMovie getWatchedMovieById(WatchedMovieId id) throws EntityNotFoundException {
    Optional<WatchedMovie> result = watchedMovieRepository.findById(id);
    if (result.isEmpty()) {
      throw new EntityNotFoundException("No watched movie entry found");
    }
    return result.get();
  }

  public List<WatchedMovie> getWatchedMoviesByUsername(String user) throws EntityNotFoundException {
    List<WatchedMovie> watchedMovieList = watchedMovieRepository.findByIdUserUsername(user);

    if (watchedMovieList.isEmpty()) {
      throw new EntityNotFoundException("No watched movie entries found for this user");
    }
    return watchedMovieList;
  }

  public WatchedMovie createOrUpdateWatchedMovie(WatchedMovieDto watchedMovieDto)
      throws EntityNotFoundException {
    return watchedMovieRepository.saveAndFlush(watchedMovieDtoMapper.toEntity(watchedMovieDto));
  }

  public WatchedMovie createNewWatchedMovie(WatchedMovieDto watchedMovieDto)
      throws EntityNotFoundException {
    WatchedMovie watchedMovie = watchedMovieDtoMapper.toEntity(watchedMovieDto);

    if (watchedMovieRepository.existsById(watchedMovie.getId())) {
      throw new EntityNotFoundException("Entry already exists");
    }

    return watchedMovieRepository.saveAndFlush(watchedMovie);
  }
}
