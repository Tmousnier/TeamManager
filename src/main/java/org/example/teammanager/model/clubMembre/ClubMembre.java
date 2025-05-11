package org.example.teammanager.model.clubMembre;

import jakarta.persistence.*;
import lombok.*;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.membre.Membre;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "club_membre")
public class ClubMembre {

        @EmbeddedId
        private ClubMembreId id;

        @ManyToOne
        @MapsId("idClub")
        @JoinColumn(name = "id_club")
        private Club club;

        @ManyToOne
        @MapsId("idMembre")
        @JoinColumn(name = "id_membre")
        private Membre membre;
}