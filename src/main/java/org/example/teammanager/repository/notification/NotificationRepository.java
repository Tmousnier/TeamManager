package org.example.teammanager.repository.notification;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.example.teammanager.model.club.Club;
import org.example.teammanager.model.clubNotification.ClubNotification;
import org.example.teammanager.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("SELECT n FROM Notification n JOIN n.clubNotifications cn JOIN cn.club c WHERE c.nom = :clubName")
    List<Notification> findByClubName(@Param("clubName") String clubName);
}