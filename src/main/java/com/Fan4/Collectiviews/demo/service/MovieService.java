package com.Fan4.Collectiviews.demo.service;

import com.Fan4.Collectiviews.demo.model.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Fan4.Collectiviews.demo.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

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
    
}
