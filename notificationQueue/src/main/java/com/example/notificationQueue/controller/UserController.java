package com.example.notificationQueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.notificationQueue.service.UserService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.validation.Valid;

import com.example.notificationQueue.dto.UserResponse;
import  com.example.notificationQueue.dto.UserRequest;
import com.example.notificationQueue.dto.ApiResponse;
import java.util.*;

@RestController 
@RequestMapping ("/api/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping ("/{email}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserByEmail(@PathVariable  String email) {
        UserResponse userResponse = userService.getUserByEmail(email);
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .status(200)
                .message("User details fetched successfully")
                .data(userResponse)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers(){

         List<UserResponse> response = userService.getAllUsers();
         ApiResponse<List<UserResponse>> result = ApiResponse.<List<UserResponse>>builder().status(200).message("All Users Fetched successfully").data(response).build();
         return  ResponseEntity.ok(result);
         
    }

    @GetMapping ("/{id}")

    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable  Long id){
         
        UserResponse response = userService.getUserById(id);
        ApiResponse<UserResponse> result = ApiResponse.<UserResponse>builder().status(200).message("User details fetched successfully").data(response).build();

        return ResponseEntity.ok(result);
    }

    @PostMapping 

    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid  @RequestBody  UserRequest request){
          
        UserResponse response = userService.createUser(request);
        ApiResponse<UserResponse> result = ApiResponse.<UserResponse>builder().status(200).message("User created successfully").data(response).build();
        return ResponseEntity.ok(result);

    }
   
    @DeleteMapping ("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUserById(@PathVariable  Long id){

         userService.deleteUser(id);

         ApiResponse<Void> response = ApiResponse.<Void>builder().status(200).message("User Deleted successfully").data(null).build();

         return  ResponseEntity.ok(response);
    }


}
