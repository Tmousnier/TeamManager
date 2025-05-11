package org.example.teammanager.dto.notification;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private String contenu;
    private LocalDateTime date;
}