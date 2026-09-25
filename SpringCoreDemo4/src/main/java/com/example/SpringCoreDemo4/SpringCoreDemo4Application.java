package com.example.SpringCoreDemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCoreDemo4Application {

	@Bean
	public UserService getUserService() {
		return new UserService();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringCoreDemo4Application.class, args);

		OrderService orderService = context.getBean(OrderService.class);
		orderService.placeOrder();
	}

}
