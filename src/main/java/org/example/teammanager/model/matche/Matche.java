package org.example.teammanager.model.matche;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.equipeMatche.EquipeMatche;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "matche")
@Data
@NoArgsConstructor
public class Matche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMatche;

    @Column(name = "date_match")
    private LocalDateTime dateMatch;

    @Column(name = "score_domicile")
    private Integer scoreDomicile;

    @Column(name = "score_exterieur")
    private Integer scoreExterieur;

    @Column(name = "statut")
    private String statut;

    @OneToMany(mappedBy = "matche")
    private List<EquipeMatche> equipeMatche;
}
