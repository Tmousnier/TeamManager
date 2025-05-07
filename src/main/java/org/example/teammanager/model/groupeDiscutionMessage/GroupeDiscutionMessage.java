package org.example.teammanager.model.groupeDiscutionMessage;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.groupeDiscution.GroupeDiscution;
import org.example.teammanager.model.message.Message;

@Entity
@Data
@Table(name = "groupediscution_message")
public class GroupeDiscutionMessage {
    @EmbeddedId
    private GroupeDiscutionMessageId id;

    @ManyToOne
    @MapsId("idGroupeDiscution") // Lie idGroupeDiscution de GroupeDiscutionMessageId à la relation GroupeDiscution
    @JoinColumn(name = "id_groupediscution", referencedColumnName = "id")
    private GroupeDiscution groupeDiscution;

    @ManyToOne
    @MapsId("idMessage") // Lie idMessage de GroupeDiscutionMessageId à la relation Message
    @JoinColumn(name = "id_message", referencedColumnName = "id")
    private Message message;
}