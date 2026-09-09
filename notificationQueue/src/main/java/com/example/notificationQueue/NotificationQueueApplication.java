package com.example.notificationQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling 
public class NotificationQueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationQueueApplication.class, args);
	}

}
