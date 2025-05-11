package org.example.teammanager.model.club;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.clubEquipe.ClubEquipe;
import org.example.teammanager.model.clubMembre.ClubMembre;
import org.example.teammanager.model.clubNotification.ClubNotification;
import org.example.teammanager.model.sportClub.SportClub;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "club")
@Data
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "description")
    private String description;

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "pays")
    private String pays;

    @Column(name = "ville")
    private String ville;

    @OneToMany(mappedBy = "club")
    private List<SportClub> sportClubs;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubMembre> clubMembres;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClubEquipe> equipes;

    @OneToMany(mappedBy = "club")
    private List<ClubNotification> notifications;
}