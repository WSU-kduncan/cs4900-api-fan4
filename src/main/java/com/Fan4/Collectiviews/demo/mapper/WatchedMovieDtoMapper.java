package com.Fan4.Collectiviews.demo.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import com.Fan4.Collectiviews.demo.dto.WatchedMovieDto;
import com.Fan4.Collectiviews.demo.model.WatchedMovie;
import com.Fan4.Collectiviews.demo.service.WatchedMovieService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring",
    uses = {WatchedMovieService.class})
public interface WatchedMovieDtoMapper {
    
    WatchedMovie toEntity(WatchedMovieDto watchedMovieDto) throws EntityNotFoundException;

    WatchedMovieDto toDto(Optional<WatchedMovie> watchedMovie) throws EntityNotFoundException;

    List<WatchedMovieDto> toDtoList(List<WatchedMovie> WatchedMovieList) throws EntityNotFoundException;
}

