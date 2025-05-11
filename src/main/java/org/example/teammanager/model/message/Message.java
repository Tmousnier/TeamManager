package org.example.teammanager.model.message;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.groupeDiscutionMessage.GroupeDiscutionMessage;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreMessage.MembreMessage;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMessage;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "date_envoie")
    private LocalDateTime dateEnvoie;

    @OneToMany(mappedBy = "message")
    private List<MembreMessage> membreMessages;

    @OneToMany(mappedBy = "message")
    private List<GroupeDiscutionMessage> groupeDiscutionMessages;


}