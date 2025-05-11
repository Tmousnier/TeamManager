package org.example.teammanager.controller.applis.notification;

import org.example.teammanager.dto.notification.NotificationDto;
import org.example.teammanager.model.notification.Notification;
import org.example.teammanager.repository.notification.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/{nomClub}") // Corrected route
    public ResponseEntity<List<NotificationDto>> getAllNotificationsByClub(@PathVariable String nomClub) {
        List<NotificationDto> notifications = notificationRepository.findByNomClub(nomClub)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notifications);
    }

    private NotificationDto convertToDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setContenu(notification.getContenu());
        dto.setDate(notification.getDate());
        return dto;
    }
}