package com.example.notificationQueue.dto;

import java.time.LocalDateTime;

import com.example.notificationQueue.entity.Notifcation_Priority;
import com.example.notificationQueue.entity.Notification_Status;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class NotificationRequest {
    
    @NotBlank (message = "Message is required")
    private String message;

    @NotBlank (message = "Priority is required")
    private Notifcation_Priority priority;


}
