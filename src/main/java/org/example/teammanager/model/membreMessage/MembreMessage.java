package org.example.teammanager.model.membreMessage;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.message.Message;

@Entity
@Data
@Table(name = "membre_message")
@NoArgsConstructor
public class MembreMessage {
    @EmbeddedId
    private MembreMessageId id;

    @ManyToOne
    @MapsId("idMembre")
    @JoinColumn(name = "id_membre")
    private Membre membre;

    @ManyToOne
    @MapsId("idMessage")
    @JoinColumn(name = "id_message")
    private Message message;
}