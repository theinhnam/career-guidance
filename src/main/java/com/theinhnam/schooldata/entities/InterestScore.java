package com.theinhnam.schooldata.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "interest_scores")
@Data
public class InterestScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User user;
    private Long majorCode;
    private Integer score = 0;
}
