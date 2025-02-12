package org.example.teammanager.model.match;

import jakarta.persistence.*;
import org.example.teammanager.model.equipe.Equipe;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer scoreDomicile;
    private Integer scoreExterieur;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "idEquipeDomicile")
    private Equipe equipeDomicile;

    @ManyToOne
    @JoinColumn(name = "idEquipeExterieur")
    private Equipe equipeExterieur;

    // Getters and Setters
}
