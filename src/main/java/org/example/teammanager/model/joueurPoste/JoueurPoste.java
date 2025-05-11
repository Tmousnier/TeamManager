package org.example.teammanager.model.joueurPoste;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.joueur.Joueur;
import org.example.teammanager.model.poste.Poste;

@Entity
@Table(name = "joueur_poste")
@Data
@NoArgsConstructor
public class JoueurPoste {

    @EmbeddedId
    private JoueurPosteId id;

    @ManyToOne
    @MapsId("idJoueur")
    @JoinColumn(name = "id_joueur", referencedColumnName = "id")
    private Joueur joueur;

    @ManyToOne
    @MapsId("idPoste")
    @JoinColumn(name = "id_poste", referencedColumnName = "id")
    private Poste poste;
}