package com.Fan4.Collectiviews.demo.mapper;

import com.Fan4.Collectiviews.demo.dto.MovieDto;
import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {MovieService.class})
public interface MovieDtoMapper {

  Movie toEntity(MovieDto movieDto) throws EntityNotFoundException;

  MovieDto toDto(Movie movie) throws EntityNotFoundException;

  List<MovieDto> toDtoList(List<Movie> movieList) throws EntityNotFoundException;
}
