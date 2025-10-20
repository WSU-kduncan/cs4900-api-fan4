package com.example.demo.model.composite;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WatchedMovieId implements Serializable{
    
    @JoinColumn(name = "username")
    String username;

    @JoinColumn(name = "movieID")
    Integer movieID;
    
}
