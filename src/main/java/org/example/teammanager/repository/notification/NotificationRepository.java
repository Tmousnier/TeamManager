package org.example.teammanager.repository.notification;

import java.util.List;
import java.util.UUID;

import org.example.teammanager.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findByEquipeId(int equipeId);
}