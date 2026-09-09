package com.example.notificationQueue.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@AllArgsConstructor 
@Data 
@NoArgsConstructor 
public class UserRequest {
    
    @NotBlank (message = "User name is required")
    private String name;

    @NotBlank (message = "Email is required")
    private String email;
}
