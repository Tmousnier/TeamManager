package org.example.teammanager.model.joueur;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.joueurPoste.JoueurPoste;
import org.example.teammanager.model.membre.Membre;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "joueur")
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id") // Utilise la clé primaire héritée de Membre
public class Joueur extends Membre {

    @Column(name = "numero_licence")
    private String numeroLicence;

    @Column(name = "taille")
    private Float taille;

    @Column(name = "poids")
    private Float poids;

    @Column(name = "numero")
    private Integer numero;

    @OneToMany(mappedBy = "joueur")
    private List<JoueurPoste> joueurPostes;
}