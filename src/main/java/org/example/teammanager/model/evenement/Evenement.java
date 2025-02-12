package org.example.teammanager.model.evenement;

import jakarta.persistence.*;
import org.example.teammanager.model.equipe.Equipe;

import java.util.Date;
import java.util.List;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private String description;

    @ManyToMany(mappedBy = "evenements")
    private List<Equipe> equipes;

    // Getters and Setters
}
