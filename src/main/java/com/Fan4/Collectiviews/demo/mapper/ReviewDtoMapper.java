package com.Fan4.Collectiviews.demo.mapper;

import com.Fan4.Collectiviews.demo.dto.ReviewDto;
import com.Fan4.Collectiviews.demo.model.Review;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewDtoMapper {

    Review toEntity(ReviewDto reviewDto) throws EntityNotFoundException;

    @Mapping(target = "username", source = "id.user.username")
    @Mapping(target = "movieID", source = "id.movie.movieID")

    ReviewDto toDto(Review review) throws EntityNotFoundException;

    List<ReviewDto> toDtoList(List<Review> reviewList) throws EntityNotFoundException;
}
