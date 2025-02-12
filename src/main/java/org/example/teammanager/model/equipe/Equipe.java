package org.example.teammanager.model.equipe;

import jakarta.persistence.*;
import org.example.teammanager.model.evenement.Evenement;
import org.example.teammanager.model.groupeDiscussion.GroupeDiscussion;
import org.example.teammanager.model.match.Match;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.club.Club;

import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String categorie;
    private String division;
    private String secteur;
    private String genre;
    private Integer points;
    private Integer poule;

    @ManyToOne
    @JoinColumn(name = "id_club")  // Définir le nom de la colonne de jointure
    private Club club;  // La propriété qui référence Club

    @OneToMany(mappedBy = "equipe")
    private List<Membre> membres;

    @OneToMany(mappedBy = "equipe")
    private List<GroupeDiscussion> groupesDiscussion;

    @ManyToMany
    @JoinTable(
            name = "evenement_equipe",
            joinColumns = @JoinColumn(name = "idEquipe"),
            inverseJoinColumns = @JoinColumn(name = "idEvenement"))
    private List<Evenement> evenements;

    @OneToMany(mappedBy = "equipeDomicile")
    private List<Match> matchsDomicile;

    @OneToMany(mappedBy = "equipeExterieur")
    private List<Match> matchsExterieur;

    // Getters and Setters
}
