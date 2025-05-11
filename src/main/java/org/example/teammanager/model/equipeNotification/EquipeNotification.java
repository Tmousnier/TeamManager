package org.example.teammanager.model.equipeNotification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.notification.Notification;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipe_notification")
public class EquipeNotification {
    @EmbeddedId
    private EquipeNotificationId id;

    @ManyToOne
    @MapsId("idEquipe")
    @JoinColumn(name = "id_equipe")
    private Equipe equipe;

    @ManyToOne
    @MapsId("idNotification")
    @JoinColumn(name = "id_notification")
    private Notification notification;

}
