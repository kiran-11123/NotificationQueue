package com.example.notificationQueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notificationQueue.dto.ApiResponse;
import com.example.notificationQueue.dto.NotificationRequest;
import com.example.notificationQueue.dto.NotificationResponse;
import com.example.notificationQueue.service.NotificationService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }


    public ResponseEntity<ApiResponse<NotificationResponse>> createNotification(@Valid  @RequestBody  NotificationRequest request){
           
        NotificationResponse response = notificationService.createNotification(request);

        ApiResponse<NotificationResponse > result = ApiResponse.<NotificationResponse>builder().status(200).message("Notification created successfully").data(response).build();

        return ResponseEntity.ok(result);
    }

    

}
