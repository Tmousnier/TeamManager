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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getNumeroTelephone() {
        return numeroTelephone;
    }
    public void setNumeroTelephone(Integer numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
    public Equipe getEquipe() {
        return equipe;
    }
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    public Club getClub() {
        return club;
    }
    public void setClub(Club club) {
        this.club = club;
    }
    public List<Joueur> getJoueurs() {
        return joueurs;
    }
    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public List<RoleMembre> getRolesMembre() {
        return rolesMembre;
    }
    public void setRolesMembre(List<RoleMembre> rolesMembre) {
        this.rolesMembre = rolesMembre;
    }
}
