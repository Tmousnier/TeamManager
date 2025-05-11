package org.example.teammanager.model.groupeDiscutionMessage;

import jakarta.persistence.*;
        import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.groupeDiscution.GroupeDiscution;
import org.example.teammanager.model.message.Message;

@Entity
@Table(name = "groupediscution_message")
@Data
@NoArgsConstructor
public class GroupeDiscutionMessage {
    @EmbeddedId
    private GroupeDiscutionMessageId id;

    @ManyToOne
    @MapsId("idGroupeDiscution")
    @JoinColumn(name = "id_groupediscution")
    private GroupeDiscution groupeDiscussion;

    @ManyToOne
    @MapsId("idMessage")
    @JoinColumn(name = "id_message")
    private Message message;
}