package org.example.teammanager.model.notification;

import jakarta.persistence.*;
import lombok.Data;
import org.example.teammanager.model.equipe.Equipe;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "notification")
@Data
public class Notification {
    @Id
    @GeneratedValue
    private UUID id;
    private String contenu;
    private Date date;
    @ManyToOne
    private Equipe equipe;
}
