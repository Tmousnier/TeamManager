package org.example.teammanager.model.groupeDiscussion;

import jakarta.persistence.*;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.message.Message;

import java.util.List;


@Entity
public class GroupeDiscussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomGroupe;

    @ManyToOne
    @JoinColumn(name = "idEquipe")
    private Equipe equipe;

    @OneToMany(mappedBy = "groupeDiscussion")
    private List<Message> messages;

    // Getters and Setters
}
