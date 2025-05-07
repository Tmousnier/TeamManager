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
        @MapsId("idClub") // Lie idClub de ClubMembreId à la relation Club
        @JoinColumn(name = "id_club", referencedColumnName = "id")
        private Club club;

        @ManyToOne
        @MapsId("idMembre") // Lie idMembre de ClubMembreId à la relation Membre
        @JoinColumn(name = "id_membre", referencedColumnName = "id")
        private Membre membre;
}