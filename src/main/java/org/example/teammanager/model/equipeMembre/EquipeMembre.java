package org.example.teammanager.model.equipeMembre;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.membre.Membre;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipe_membre")
public class EquipeMembre {

    @EmbeddedId
    private EquipeMembreId id;

    @ManyToOne
    @MapsId("idEquipe") // Lie idEquipe de EquipeMembreId à la relation Equipe
    @JoinColumn(name = "id_equipe", referencedColumnName = "id")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idMembre") // Lie idMembre de EquipeMembreId à la relation Membre
    @JoinColumn(name = "id_membre", referencedColumnName = "id")
    private Membre membre;
}