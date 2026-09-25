package com.example.SpringCoreDemo42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// ApplicationContext context = 
		SpringApplication.run(Application.class, args);

		// PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

		// paymentGateway.setType("paytm");
		// paymentGateway.setRetryCnt(4);

		// System.out.println(paymentGateway.getType());
		// System.out.println(paymentGateway.getRetryCnt());
		// System.out.println(paymentGateway.isEnabled());
		// System.out.println(paymentGateway.timeout());


		// paymentGateway.print();
		

	}

}
