package com.example.XMLBasedConfigDemo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class XmlBasedConfigDemoApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		//get bean by id/name
		// OrderService order = (OrderService) context.getBean("orderService");

		//get bean by type
		// OrderService order = context.getBean("orderService1",OrderService.class);
		// order.placeOrder();

		// PaymentService paymentService =  context.getBean("paymentService", PaymentService.class);
		// paymentService.pay();
		
		// //get bean by name
		// OrderService order = context.getBean("ord2",OrderService);
		// order.placeOrder();

		//Dependency injection
		// OrderService order = (OrderService)context.getBean("orderService");
		// order.placeOrder();
		
		// UserService user = (UserService) context.getBean("userService");
		UserService user = context.getBean(UserService.class);
		
		// Map<Integer,String> username  = user.getUsername();
		// System.out.println(username);
		
		context.close();
	}

}
