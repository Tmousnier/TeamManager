package org.example.teammanager.model.membre;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.clubMembre.ClubMembre;
import org.example.teammanager.model.equipeMatche.EquipeMatche;
import org.example.teammanager.model.equipeMembre.EquipeMembre;
import org.example.teammanager.model.membreMessage.MembreMessage;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "membre")
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMembre;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance;

    @Column(name = "date_inscription")
    private LocalDate dateInscription;

    @Column(name = "email")
    private String email;

    @Column(name = "genre")
    private String genre;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    @Column(name = "password")
    private String password;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "statut")
    private String statut;

    @OneToMany(mappedBy = "membre")
    private List<MembreRoleMembre> membreRoleMembres;

    @OneToMany(mappedBy = "membre", fetch = FetchType.EAGER)
    private List<ClubMembre> clubMembres;

    @OneToMany(mappedBy = "membre")
    private List<MembreMessage> membreMessages;

    @OneToMany(mappedBy = "membre")
    private List<EquipeMembre> equipeMembres;
}