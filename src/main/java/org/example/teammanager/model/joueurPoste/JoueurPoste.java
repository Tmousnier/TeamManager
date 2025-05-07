package org.example.teammanager.model.joueurPoste;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.joueur.Joueur;
import org.example.teammanager.model.poste.Poste;

@Entity
@Table(name = "joueur_poste")
@Data
public class JoueurPoste {

    @EmbeddedId
    private JoueurPosteId id;

    @ManyToOne
    @MapsId("idJoueur") // Lie le champ idJoueur de JoueurPosteId à cette relation
    @JoinColumn(name = "id_joueur", referencedColumnName = "id") // Nom de colonne corrigé
    private Joueur joueur; // Nom de variable corrigé

    @ManyToOne
    @MapsId("idPoste") // Lie le champ idPoste de JoueurPosteId à cette relation
    @JoinColumn(name = "id_poste", referencedColumnName = "id") // Nom de colonne corrigé
    private Poste poste; // Nom de variable corrigé
}