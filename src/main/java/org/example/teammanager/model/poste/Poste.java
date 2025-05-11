package org.example.teammanager.model.poste;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.joueurPoste.JoueurPoste;
import org.hibernate.boot.beanvalidation.IntegrationException;

import java.util.List;

@Entity
@Table(name = "poste")
@Data
@NoArgsConstructor
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPoste;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "poste")
    private List<JoueurPoste> joueurPostes;
}