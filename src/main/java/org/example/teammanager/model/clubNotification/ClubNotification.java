package org.example.teammanager.model.clubNotification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.notification.Notification;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "club_notification")
public class ClubNotification {
    @EmbeddedId
    private ClubNotificationId id;

    @ManyToOne
    @MapsId("idClub")
    @JoinColumn(name = "id_club")
    private Club club;

    @ManyToOne
    @MapsId("idNotification")
    @JoinColumn(name = "id_notification")
    private Notification notification;

}
