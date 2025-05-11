package org.example.teammanager.model.equipe;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.clubEquipe.ClubEquipe;
import org.example.teammanager.model.equipeEvenement.EquipeEvenement;
import org.example.teammanager.model.equipeMatche.EquipeMatche;
import org.example.teammanager.model.equipeMembre.EquipeMembre;

import java.util.List;

@Entity
@Table(name = "equipe")
@Data
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEquipe;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "division")
    private String division;

    @Column(name = "genre")
    private String genre;

    @Column(name = "nom")
    private String nom;

    @Column(name = "points")
    private Integer points;

    @Column(name = "poule")
    private String poule;

    @Column(name = "secteur")
    private String secteur;

    @OneToMany(mappedBy = "equipe")
    private List<EquipeMembre> equipeMembres;

    @OneToMany(mappedBy = "equipe")
    private List<EquipeEvenement> equipeEvenements;

    @OneToMany(mappedBy = "equipe")
    private List<ClubEquipe> clubEquipes;

    @OneToMany(mappedBy = "equipe")
    private List<EquipeMatche> equipeMatches;
}
