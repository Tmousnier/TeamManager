package org.example.teammanager.model.sport;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sport")
@Data
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom")
    private String nom;
    private int nombreClubs;
}