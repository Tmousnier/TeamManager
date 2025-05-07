package org.example.teammanager.model.equipe;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.example.teammanager.model.equipeEvenement.EquipeEvenement;

import java.util.List;

@Entity
@Table(name = "equipe")
@Data
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String categorie;
    private String division;
    private String secteur;
    private Integer points;
    private String poule;
    private String genre;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EquipeEvenement> equipeEvenements;
}
