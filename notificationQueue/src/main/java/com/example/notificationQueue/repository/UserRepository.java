package com.example.notificationQueue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.notificationQueue.entity.User;

public interface UserRepository  extends JpaRepository<User, Long> {
        

    Optional<User> findByEmail(String email);
}
