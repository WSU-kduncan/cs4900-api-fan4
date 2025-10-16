package com.example.demo.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.model.composite.ReviewId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class Review {

  @EmbeddedId
  ReviewId id;

  @Column(name = "rating", nullable = false)
  Integer rating;

  @Column(name = "writtenReview", length = 2000)
  String writtenReview;

  @Column(name = "reviewDate", nullable = false)
  @CreationTimestamp
  Instant reviewDate;
}
