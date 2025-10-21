package com.Fan4.Collectiviews.demo.mapper;

import com.Fan4.Collectiviews.demo.model.Movie;
import java.util.List;
import org.mapstruct.Mapper;
import com.Fan4.Collectiviews.demo.dto.MovieDto;
import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring")
public interface MovieDtoMapper {
    
    Movie toEntity (MovieDto movieDto) throws EntityNotFoundException;

    MovieDto toDto(Movie movie) throws EntityNotFoundException;

    List<MovieDto> toDtoList(List<Movie> movieList) throws EntityNotFoundException;
}
