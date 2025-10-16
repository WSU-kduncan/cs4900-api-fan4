package com.Fan4.Collectiviews.demo.model;

import java.time.Instant;

import com.Fan4.Collectiviews.demo.model.composite.ReviewId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

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
    Instant reviewDate;
}
