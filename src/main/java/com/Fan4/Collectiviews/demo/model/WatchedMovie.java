package com.Fan4.Collectiviews.demo.model;

import java.time.LocalDate;

import com.Fan4.Collectiviews.demo.model.composite.WatchedMovieId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class WatchedMovie {

	@EmbeddedId
	WatchedMovieId id;

    @Column(name = "watchedDate", nullable = false)
	LocalDate watchedDate; // Best Date class?

}