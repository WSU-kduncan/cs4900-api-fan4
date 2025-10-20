package com.example.demo.model;

import java.time.LocalDate;

import com.example.demo.model.composite.ReviewId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review {

    @EmbeddedId
    ReviewId id;
    
    Integer rating;

    String writtenReview;

    LocalDate reviewDate;
}
