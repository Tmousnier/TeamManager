package org.example.teammanager.model.evenement;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.equipeEvenement.EquipeEvenement;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evenement")
@Data
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String lieux;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private List<EquipeEvenement> equipeEvenements;
}