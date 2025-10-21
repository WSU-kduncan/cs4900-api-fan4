package com.Fan4.Collectiviews.demo.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ReviewDto {
    String username;
    Integer movieID;
    byte rating;
    String writtenReview;
    Instant reviewDate;
}
