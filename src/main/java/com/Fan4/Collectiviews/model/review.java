package com.Fan4.Collectiviews.model;

import com.Fan4.Collectiviews.model.composite.reviewId;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class review {

	@EmbeddedId
	reviewId id;

    @Column(name = "rating", nullable = false)
	byte rating;


    @Column(name = "writtenReview", nullable = true)
    String writtenReview;

    @Column(name = "reviewDate", nullable = false)
    Instant reviewDate;
}
