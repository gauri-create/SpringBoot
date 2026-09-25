package com.example.SpringCoreDemo3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringCoreDemo3Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService order = context.getBean(OrderService.class);
		order.placeOrder();
		((AbstractApplicationContext) context).close();
	}

}
