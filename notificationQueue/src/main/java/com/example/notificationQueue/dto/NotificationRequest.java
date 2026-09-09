package com.example.notificationQueue.dto;

import com.example.notificationQueue.entity.Notifcation_Priority;
import com.example.notificationQueue.entity.Notification_Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class NotificationRequest {
     
    private String message;
    private Notifcation_Priority priority;
    private LocalDateTime createdAt;
    private Notification_Status status;

}
