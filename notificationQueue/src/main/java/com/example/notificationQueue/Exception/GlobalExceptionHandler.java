package com.example.notificationQueue.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.notificationQueue.Exception.UserNotFoundException;
import com.example.notificationQueue.dto.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice 
@Slf4j 
public class GlobalExceptionHandler {
       
    @ExceptionHandler (Exception.class)

    public  ResponseEntity<ApiResponse<Void>> handleGenericException(Exception e){
          log.error("Unexpected error occured" , e);
          ApiResponse<Void> response =
                ApiResponse.<Void>builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message("Something went wrong")
                        .data(null)
                        .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }


    
    public ResponseEntity<ApiResponse<Void>> handleUserNotFound(UserNotFoundException e){
          
               log.error(
            "User Not found",
            e.getMessage()
    );

      ApiResponse<Void>  response = ApiResponse.<Void>builder().status(404).message("User Not found").data(null).build();

      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .body(response);
    }
}
