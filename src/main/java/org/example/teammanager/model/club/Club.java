package org.example.teammanager.model.club;

import jakarta.persistence.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.sport.Sport;

import java.util.Date;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String adresse;
    private String ville;
    private String pays;
    private String description;
    private Integer numeroTelephone;
    private Date dateCreation;

    @OneToMany(mappedBy = "club")
    private List<Equipe> equipes;

    @OneToMany(mappedBy = "club")
    private List<Sport> sports;

    @OneToMany(mappedBy = "club")
    private List<Membre> membres;

    // Getters and Setters
}
