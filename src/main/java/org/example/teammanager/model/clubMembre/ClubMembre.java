package org.example.teammanager.model.clubMembre;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.membre.Membre;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "club_membre")
public class ClubMembre {

        @EmbeddedId
        private ClubMembreId id;

        @ManyToOne
        @MapsId("idClub") // Associe ce champ avec la clé primaire composite
        @JoinColumn(name = "id_club")
        private Club club;

        @ManyToOne
        @MapsId("idMembre") // Associe ce champ avec la clé primaire composite
        @JoinColumn(name = "id_membre")
        private Membre membre;
}