package com.example.notificationQueue.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.notificationQueue.entity.Notifications;
import java.util.*;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
        
    Optional<Notifications> findById(Long id);
     
    List<Notifications> findByStatus(String status);
    
    List<Notifications> findByPriority(String priority);

    List<Notifications> findByUserId(Long userId);

}
