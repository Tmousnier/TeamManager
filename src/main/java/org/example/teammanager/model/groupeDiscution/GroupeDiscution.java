package org.example.teammanager.model.groupeDiscution;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "groupe_discution")
public class GroupeDiscution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom_groupe;
}