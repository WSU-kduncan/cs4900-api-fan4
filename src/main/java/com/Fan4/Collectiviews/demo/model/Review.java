package com.Fan4.Collectiviews.demo.model;

import com.Fan4.Collectiviews.demo.model.composite.ReviewId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table
public class Review {

  @EmbeddedId
  ReviewId id;

  @Column(name = "rating", nullable = false)
  byte rating;

  @Column(name = "writtenReview", nullable = true)
  String writtenReview;

  @Column(name = "reviewDate", nullable = false)
  @CreationTimestamp
  Instant reviewDate;
}
