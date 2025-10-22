package com.Fan4.Collectiviews.demo.repository;

import com.Fan4.Collectiviews.demo.model.Review;
import com.Fan4.Collectiviews.demo.model.composite.ReviewId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
  List<Review> findByIdUserUsername(String username);
}
