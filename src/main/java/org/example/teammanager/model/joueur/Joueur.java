package org.example.teammanager.model.joueur;

import jakarta.persistence.*;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.poste.Poste;

import java.util.List;

@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numero;
    private Float poids;
    private Float taille;
    private String numeroLicence;

    @ManyToOne
    @JoinColumn(name = "idMembre")
    private Membre membre;

    @ManyToMany
    @JoinTable(
            name = "joueur_postes",
            joinColumns = @JoinColumn(name = "idJoueur"),
            inverseJoinColumns = @JoinColumn(name = "idPoste"))
    private List<Poste> postes;

    // Getters and Setters
}
