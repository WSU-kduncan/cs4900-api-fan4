package com.Fan4.Collectiviews.model.composite;

import com.Fan4.Collectiviews.model.user;
import com.Fan4.Collectiviews.model.movie;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class reviewId implements Serializable {

    @JoinColumn(name = "username", nullable = false)
    @ManyToOne
    user user;

    @JoinColumn(name = "movieID", nullable = false)
    @ManyToOne
    movie movie;
}