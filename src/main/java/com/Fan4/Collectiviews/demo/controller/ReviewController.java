package com.Fan4.Collectiviews.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fan4.Collectiviews.demo.dto.ReviewDto;
import com.Fan4.Collectiviews.demo.mapper.ReviewDtoMapper;
import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.model.Review;
import com.Fan4.Collectiviews.demo.model.User;
import com.Fan4.Collectiviews.demo.model.composite.ReviewId;
import com.Fan4.Collectiviews.demo.service.ReviewService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

  private final ReviewService reviewService;
  private final ReviewDtoMapper reviewMapper;

  @GetMapping
  ResponseEntity<List<ReviewDto>> getAllReviews() {
    List<Review> reviews = reviewService.getAllReviews();
    return new ResponseEntity<>(reviewMapper.toDtoList(reviews), HttpStatus.OK);
  }

  @GetMapping("/by-id/{username}/{movieID}")
  ResponseEntity<ReviewDto> getReviewById(
      @PathVariable String username, @PathVariable Integer movieID) {
    ReviewId id = new ReviewId();
    id.setUser(new User());
    id.getUser().setUsername(username);
    id.setMovie(new Movie());
    id.getMovie().setMovieID(movieID);

    try {
      Review review = reviewService.getReviewById(id);
      return new ResponseEntity<>(reviewMapper.toDto(review), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/by-user/{username}")
  ResponseEntity<List<ReviewDto>> getReviewsByUser(@PathVariable String username) {
    List<Review> reviews = reviewService.getReviewsByUser(username);
    return new ResponseEntity<>(reviewMapper.toDtoList(reviews), HttpStatus.OK);
  }

  @DeleteMapping("/by-id/{username}/{movieID}")
  ResponseEntity<Void> deleteReviewById(
    @PathVariable String username, @PathVariable Integer movieID) {
    ReviewId id = new ReviewId();
    id.setUser(new User());
    id.getUser().setUsername(username);
    id.setMovie(new Movie());
    id.getMovie().setMovieID(movieID);
    try {
      reviewService.deleteReviewById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ReviewDto> createOrUpdateReview(@RequestBody ReviewDto reviewDto) {
    Review review;
    try {
      review = reviewService.createOrUpdateReview(reviewDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(reviewMapper.toDto(review), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
    Review review;
    ReviewId id = new ReviewId();
    id.setUser(new User());
    id.getUser().setUsername(reviewDto.getUsername());
    id.setMovie(new Movie());
    id.getMovie().setMovieID(reviewDto.getMovieID());

    try {
      review = reviewService.getReviewById(id);
    } catch (EntityNotFoundException e) {
      review = reviewService.createNewReview(reviewDto);
      return new ResponseEntity<>(reviewMapper.toDto(review), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
