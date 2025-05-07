package org.example.teammanager.model.sportClub;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.sport.Sport;

@Data
@Entity
@IdClass(SportClubId.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sport_club")
public class SportClub {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_club", nullable = false)
    private Club club;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_sport", nullable = false)
    private Sport sport;

}
