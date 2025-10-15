package com.example.demo.model;

import com.example.demo.model.composite.reviewId;
import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class review {

    @EmbeddedId
    reviewId id;

    @Column(name = "rating", nullable = false)
    Integer rating;

    @Column(name = "writtenReview", length = 2000)
    String writtenReview;

    @Column(name = "reviewDate", nullable = false)
    @CreationTimestamp
    Instant releaseDate;
}