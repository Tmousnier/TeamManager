package org.example.teammanager.model.joueur;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.membre.Membre;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "joueur")
public class Joueur extends Membre {
    private String numero;
    private String numero_licence;
    private Float poids;
    private Float taille;
}
