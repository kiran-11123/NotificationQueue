package com.example.notificationQueue.service;
import com.example.notificationQueue.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import com.example.notificationQueue.Exception.UserNotFoundException;
import com.example.notificationQueue.dto.UserRequest;
import com.example.notificationQueue.dto.UserResponse;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.notificationQueue.entity.User;

@Service 
@Slf4j 
public class UserService {
    
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUserByEmail(String email) {
        
        try{

        log.info("Fetching user details for email {} ", email);
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserResponse.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .build();
        } else {
            log.info("User not found for email {} " , email);
            throw new UserNotFoundException("User not found with email: " + email);
        }

    } 
     catch(UserNotFoundException e){
         throw e;
     }
     catch(RuntimeException e){
         throw e;
     }
    }

    
    public List<UserResponse> getAllUsers() {
        try{
        log.info("Fetching all users");
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .build();
            userResponses.add(userResponse);
        }
        return userResponses;
    } 
     catch(RuntimeException e){
         throw e;
     }
    }


    public UserResponse getUserById(Long id) {
        try{
            log.info("Fetching user details for id {} ", id);
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                return UserResponse.builder()
                        .id(user.getId())
                        .email(user.getEmail())
                        .build();
            } else {
                log.info("User not found for id {} " , id);
                throw new UserNotFoundException("User not found with id: " + id);
            }
        } catch (UserNotFoundException e) {
            throw e;
        } catch (RuntimeException e) {
            throw e;
        }

    }

    public UserResponse createUser(UserRequest  request) {
        try{
            log.info("Creating new user with email {} ", request.getEmail());
            User user = new User();
            user.setEmail(request.getEmail());
            User savedUser = userRepository.save(user);
            return UserResponse.builder()
                    .id(savedUser.getId())
                    .email(savedUser.getEmail())
                    .build();
        } catch (RuntimeException e) {
           throw e;
        }
    }
    
    public void  deleteUser(Long id){
         
        try {

        log.info("Deleting user with id {}", id);

        getUserById(id);

        userRepository.deleteById(id);

        log.info("User deleted successfully with id {}", id);

    } catch (RuntimeException e) {

        log.error("Error while deleting user with id {}", id, e);

        throw e;
    }
    } 
}
