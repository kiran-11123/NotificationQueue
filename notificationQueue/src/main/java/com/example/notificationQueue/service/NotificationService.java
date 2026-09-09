package com.example.notificationQueue.service;
import com.example.notificationQueue.Exception.UserNotFoundException;
import com.example.notificationQueue.dto.NotificationRequest;
import com.example.notificationQueue.dto.NotificationResponse;
import com.example.notificationQueue.repository.NotificationRepository;
import com.example.notificationQueue.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import javax.management.Notification;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.notificationQueue.entity.Notifcation_Priority;
import com.example.notificationQueue.entity.Notification_Status;
import com.example.notificationQueue.dto.NotificationResponse;
import com.example.notificationQueue.entity.User;
import com.example.notificationQueue.entity.Notifications;
import java.util.*;




@Service 
@Slf4j 

public class NotificationService {
      
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository , UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }
    

   public NotificationResponse createNotification(
            NotificationRequest request
    ) {

        log.info(
                "Creating notification for user: {}",
                request.getUserId()
        );

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id: " + request.getUserId()
                        )
                );

        Notifications notification = Notifications.builder()
                .message(request.getMessage())
                .priority(request.getPriority())
                .status(Notification_Status.PROCESSING)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        Notifications savedNotification =
                notificationRepository.save(notification);

        log.info(
                "Notification created successfully with id: {}",
                savedNotification.getId()
        );

        return NotificationResponse.builder()
                .message(savedNotification.getMessage())
                .status(savedNotification.getStatus())
                .createdAt(savedNotification.getCreatedAt())
                .userId(savedNotification.getUser().getId())
                .build();
    }

    
    @Scheduled()
    public  void sendNotifications(){
          try{
            log.info("Scheduling the notifications which are in processing stage");
            
            List<Notifications> notifications = notificationRepository.findByStatus("PROCESSING");

            PriorityQueue<Notifications> pq = new PriorityQueue<>((a,b)->{
                 if(a.getPriority().equals(b.getPriority())){
                     return a.getCreatedAt() .compareTo(b.getCreatedAt());
                 }
                 return a.getPriority().compareTo(b.getPriority());
            });

            
          }
          catch(Exception er){
             throw er;
          }
    }
    





}
