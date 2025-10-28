package com.Fan4.Collectiviews.demo.service;

import com.Fan4.Collectiviews.demo.dto.ReviewDto;
import com.Fan4.Collectiviews.demo.mapper.ReviewDtoMapper;
import com.Fan4.Collectiviews.demo.model.Review;
import com.Fan4.Collectiviews.demo.model.composite.ReviewId;
import com.Fan4.Collectiviews.demo.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final ReviewDtoMapper reviewMapper;

  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  public Review getReviewById(ReviewId id) throws EntityNotFoundException {
    Optional<Review> review = reviewRepository.findById(id);
    if (review.isEmpty()) {
      throw new EntityNotFoundException("Review not found for User: "
          + id.getUser().getUsername() + " MovieID: " + id.getMovie().getMovieID());
    }
    return review.get();
  }

  public List<Review> getReviewsByUser(String username) {
    return reviewRepository.findByIdUserUsername(username);
  }

  public Review createOrUpdateReview(ReviewDto reviewDto) throws EntityNotFoundException {
    return reviewRepository.saveAndFlush(reviewMapper.toEntity(reviewDto));
  }

  public Review createNewReview(ReviewDto reviewDto) throws EntityNotFoundException {
    Review review = reviewMapper.toEntity(reviewDto);
    if (reviewRepository.existsById(review.getId())) {
      throw new IllegalArgumentException("Review already exists for User: ");
    }
    return reviewRepository.saveAndFlush(review);
  }
}
