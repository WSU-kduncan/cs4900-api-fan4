package com.Fan4.Collectiviews.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.Fan4.Collectiviews.demo.dto.ReviewDto;
import com.Fan4.Collectiviews.demo.model.Review;
import com.Fan4.Collectiviews.demo.service.ReviewService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(
  componentModel = "spring",
  uses = {ReviewService.class}
)
public interface ReviewDtoMapper {

  @Mapping(target = "id.user.username", source = "username")
  @Mapping(target = "id.movie.movieID", source = "movieID")
  Review toEntity(ReviewDto reviewDto) throws EntityNotFoundException;

  @Mapping(target = "username", source = "id.user.username")
  @Mapping(target = "movieID", source = "id.movie.movieID")
  ReviewDto toDto(Review review) throws EntityNotFoundException;

  List<ReviewDto> toDtoList(List<Review> reviewList) throws EntityNotFoundException;
}
