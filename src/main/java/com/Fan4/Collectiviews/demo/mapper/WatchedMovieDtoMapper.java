package com.Fan4.Collectiviews.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;
import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.service.WatchedMovieService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring",
    uses = {WatchedMovieService.class})
public interface WatchedMovieDtoMapper {

  @Mapping(target = "id.user.username", source = "user")
  @Mapping(target = "id.movie.movieID", source = "movieID")
  WatchedMovie toEntity(WatchedMovieDto watchedMovieDto) throws EntityNotFoundException;

  @Mapping(target = "user", source = "id.user.username")
  @Mapping(target = "movieID", source = "id.movie.movieID")
  WatchedMovieDto toDto(WatchedMovie watchedMovie) throws EntityNotFoundException;

  List<WatchedMovieDto> toDtoList(List<WatchedMovie> WatchedMovieList)
      throws EntityNotFoundException;
}
