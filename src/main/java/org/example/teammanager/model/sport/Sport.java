package org.example.teammanager.model.sport;

import jakarta.persistence.*;
import org.example.teammanager.model.club.Club;

@Entity
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    // Getters and Setters
}
