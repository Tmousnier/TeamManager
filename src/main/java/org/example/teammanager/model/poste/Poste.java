package org.example.teammanager.model.poste;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "poste")
public class Poste {
    @Id
    private int id;
    private String nom;
}
