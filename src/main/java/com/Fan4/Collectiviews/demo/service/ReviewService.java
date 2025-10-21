package com.Fan4.Collectiviews.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Fan4.Collectiviews.demo.model.Review;
import com.Fan4.Collectiviews.demo.model.composite.ReviewId;
import com.Fan4.Collectiviews.demo.repository.ReviewRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(ReviewId id) throws EntityNotFoundException {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isEmpty()) {
            throw new EntityNotFoundException(
                "Review not found for User: " + id.getUser().getUsername() + " MovieID: " + id.getMovie().getMovieID());
        }
        return review.get();
    }

    public List<Review> getReviewsByUser(String username) {
        return reviewRepository.findByIdUserUsername(username);
    }
}
