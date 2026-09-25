package com.example.SpringCoreDemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreDemo2Application {

	public static void main(String[] args) {
		// SpringApplication.run(SpringCoreDemo2Application.class, args);

		CartService cart = new CartService();
		cart.addToCart();
	}

}
