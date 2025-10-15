package com.example.demo.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class user {
    
    @Id
    @Column(name = "username", length = 30, nullable = false)
    String username;

    @Column(name = "name", length = 50)
    String name;

    @Column(name = "password_hash", length = 30, nullable = false)
    String passwordHash;

    @Column(name = "birthYear", nullable = false)
    LocalDate birthYear;
}
