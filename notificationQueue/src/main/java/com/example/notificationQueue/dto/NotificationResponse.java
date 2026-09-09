package com.example.notificationQueue.dto;

import java.time.LocalDateTime;

import com.example.notificationQueue.entity.Notification_Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class NotificationResponse {

    private Long notification_id;
    private String message;
    private Notification_Status status;
    private LocalDateTime createdAt;
    private Long userId;

}
