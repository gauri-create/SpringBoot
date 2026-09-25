package com.example.SpringScopeDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringScopeDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		OrderService order1 = context.getBean(OrderService.class);
		OrderService order2 = context.getBean(OrderService.class);
		// OrderService order3 = new OrderService();
		// order1.placeOrder();
		// order2.placeOrder();
		// System.out.println(order1 == order2);
		// System.out.println(order1 == order3);
		// System.out.println(order1);
		// System.out.println(order2);
		// System.out.println(order3);

		// ((AbstractApplicationContext) context).close();
	}  

}
