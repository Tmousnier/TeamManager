package org.example.teammanager.model.matche;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "matche")
@Data
public class Matche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date_Match;
    private int score_Domicile;
    private int score_Exterieur;
    private String statut;
}
