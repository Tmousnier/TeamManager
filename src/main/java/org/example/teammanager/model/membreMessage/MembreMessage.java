package org.example.teammanager.model.membreMessage;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.message.Message;

@Entity
@Data
@Table(name = "membre_message")
public class MembreMessage {
    @EmbeddedId
    private MembreMessageId id;

    @ManyToOne
    @MapsId("idMembre")
    @JoinColumn(name = "id_membre", referencedColumnName = "id")
    private Membre membre;

    @ManyToOne
    @MapsId("idMessage")
    @JoinColumn(name = "id_message", referencedColumnName = "id")
    private Message message;
}