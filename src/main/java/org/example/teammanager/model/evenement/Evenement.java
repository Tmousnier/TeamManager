package org.example.teammanager.model.evenement;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.equipeEvenement.EquipeEvenement;

import java.time.LocalDate;
import java.util.List;

@Table(name = "evenement")
@Data
@NoArgsConstructor
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idEvenement;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "lieux")
    private String lieux;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @OneToMany(mappedBy = "evenement")
    private List<EquipeEvenement> equipeEvenements;
}