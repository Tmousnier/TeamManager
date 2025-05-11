package org.example.teammanager.model.notification;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teammanager.model.clubEquipe.ClubEquipe;
import org.example.teammanager.model.clubNotification.ClubNotification;
import org.example.teammanager.model.clubNotification.ClubNotificationId;
import org.example.teammanager.model.equipe.Equipe;
import org.example.teammanager.model.equipeNotification.EquipeNotification;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notification")
@Data
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToMany(mappedBy = "notification")
    private List<ClubNotification> clubNotifications;

    @OneToMany(mappedBy = "notification")
    private List<EquipeNotification> equipeNotifications;
}
