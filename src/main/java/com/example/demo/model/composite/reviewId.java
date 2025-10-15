package com.example.demo.model.composite;

import com.example.demo.model.user;
import com.example.demo.model.movie;
import java.io.Serializable;
import jakarta.persistence.*;
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
