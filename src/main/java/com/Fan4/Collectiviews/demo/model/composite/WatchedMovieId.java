package com.Fan4.Collectiviews.demo.model.composite;

import java.io.Serializable;

import com.Fan4.Collectiviews.demo.model.Movie;
import com.Fan4.Collectiviews.demo.model.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class WatchedMovieId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "movieID", nullable = false)
    Movie movie;
}