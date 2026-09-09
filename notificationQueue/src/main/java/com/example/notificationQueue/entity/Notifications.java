package com.example.notificationQueue.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import io.micrometer.common.lang.Nullable;

@Entity 
@Builder 
@Table (name = "notifications")
@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class Notifications {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    
    @Column (nullable = false)
    private String message;
    
    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private Notifcation_Priority priority;
     
    @Column (nullable = false)
    private LocalDateTime createdAt;
 
    @Enumerated (EnumType.STRING)
    private Notification_Status status;
      
    
   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
