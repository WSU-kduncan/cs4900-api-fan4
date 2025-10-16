package com.Fan4.Collectiviews.model;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class user {

	@Id
	@Column(name = "username", length = 30 ,nullable = false)
	String username; 

	@Column(name = "name", length = 50, nullable = true)
	String name;

	@Column(name = "password_hash", length = 30, nullable = false)
	String password_hash;

	@Column(name = "birthDate", nullable = false)
	LocalDate birthDate; // Best data type?


}
