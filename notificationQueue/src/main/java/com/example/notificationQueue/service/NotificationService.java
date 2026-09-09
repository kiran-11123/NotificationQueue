package com.example.notificationQueue.service;
import com.example.notificationQueue.repository.NotificationRepository;
import com.example.notificationQueue.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service 
public class NotificationService {
      
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository , UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }
     

    


}
