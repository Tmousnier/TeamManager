package org.example.teammanager.model.equipeMembre;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.membre.Membre;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipe_membre")
public class EquipeMembre {

    @EmbeddedId
    private EquipeMembreId id;

    @ManyToOne
    @MapsId("idEquipe") // Associe ce champ avec la clé primaire composite
    @JoinColumn(name = "id_Equipe")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idMembre") // Associe ce champ avec la clé primaire composite
    @JoinColumn(name = "id_Membre")
    private Membre membre;
}
