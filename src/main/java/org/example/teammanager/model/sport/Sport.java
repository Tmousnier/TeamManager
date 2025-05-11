package org.example.teammanager.model.sport;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.sportClub.SportClub;

import java.util.List;

@Entity
@Table(name = "sport")
@Data
@NoArgsConstructor
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idSport;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "sport")
    private List<SportClub> sportClubs;
}