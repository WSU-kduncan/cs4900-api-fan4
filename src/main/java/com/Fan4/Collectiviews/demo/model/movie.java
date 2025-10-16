package com.Fan4.Collectiviews.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class movie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Best strategy type?
	@Column(name = "movieID", nullable = false)
	Integer movieID;

	@Column(name = "title", length = 100, nullable = false)
	String title;

	@Column(name = "director", length = 50, nullable = true)
	String director;

	@Column(name = "genre", length = 30, nullable = true)
	String genre;

    @Column(name = "releaseDate", nullable = false)
	LocalDate releaseDate; // Best Date class?

}
