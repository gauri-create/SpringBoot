package com.example.coreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.notification.NotificationService;
import com.example.notification.EmailService;
import com.example.notification.FakeEmailService;

@SpringBootApplication
public class CoreDemoApplication {

	public static void main(String[] args) {
		NotificationService notification = new EmailService();
		OrderService order = new OrderService();
		order.setNotification(notification);
		order.placeOrder();
	}

}
