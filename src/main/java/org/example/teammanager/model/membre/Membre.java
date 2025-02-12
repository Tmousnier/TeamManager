package org.example.teammanager.model.membre;

import jakarta.persistence.*;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.joueur.Joueur;
import org.example.teammanager.model.message.Message;
import org.example.teammanager.model.roleMembre.RoleMembre;

import java.util.Date;
import java.util.List;

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private String genre;
    private Date dateDeNaissance;
    private String email;
    private Integer numeroTelephone;
    private String password;
    private Date dateInscription;

    @ManyToOne
    @JoinColumn(name = "idEquipe")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;

    @OneToMany(mappedBy = "membre")
    private List<Joueur> joueurs;

    @OneToMany(mappedBy = "membre")
    private List<Message> messages;

    @ManyToMany
    @JoinTable(
            name = "membre_rolemembre",
            joinColumns = @JoinColumn(name = "idMembre"),
            inverseJoinColumns = @JoinColumn(name = "idRoleMembre"))
    private List<RoleMembre> rolesMembre;

    // Getters and Setters
}
