package com.example.BeanLifeCycleDemo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class BeanLifeCycleDemoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// OrderService order = context.getBean(OrderService.class);
		// order.placeOrder();

		// UserService userService = context.getBean(UserService.class);
		// userService.setBeanName("userbean2");

		

		CartService cart = context.getBean(CartService.class);
		System.out.println(cart.getValue(1));


		context.close();

		// ((AbstractApplicationContext) context).close();
	}

}
