package com.example.CircularDependencyDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

// import com.example.CircularDependencyDemo.Simple.A;

@SpringBootApplication
public class CircularDependencyDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
			OrderService order = context.getBean(OrderService.class);
			order.placeOrder();

			// A a = new A();
		((AbstractApplicationContext) context).close();
		
	}

}
