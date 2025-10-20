package com.example.demo.model.composite;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class ReviewId implements Serializable {
    
    @JoinColumn(name = "username", nullable = false)
    private String username;

    @JoinColumn(name = "movieID")
    private Integer movieID;
}
