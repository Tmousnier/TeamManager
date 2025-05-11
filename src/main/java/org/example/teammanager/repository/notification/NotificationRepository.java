package org.example.teammanager.repository.notification;

import java.util.List;

import org.example.teammanager.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("SELECT n FROM Notification n JOIN n.clubNotifications cn JOIN cn.club c WHERE c.nom = :nomClub")
    List<Notification> findByNomClub(@Param("nomClub") String nomClub);
}