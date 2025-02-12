package org.example.teammanager.model.message;

import jakarta.persistence.*;
import org.example.teammanager.model.groupeDiscussion.GroupeDiscussion;
import org.example.teammanager.model.membre.Membre;

import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String contenu;
    private Date dateEnvoie;

    @ManyToOne
    @JoinColumn(name = "idMembre")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "idGrpDiscution")
    private GroupeDiscussion groupeDiscussion;

    // Getters and Setters
}
