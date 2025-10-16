package com.Fan4.Collectiviews.model;

import com.Fan4.Collectiviews.model.composite.watchedMovieId;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class watchedMovie {

	@EmbeddedId
	watchedMovieId id;

    @Column(name = "watchedDate", nullable = false)
	LocalDate watchedDate; // Best Date class?

}
