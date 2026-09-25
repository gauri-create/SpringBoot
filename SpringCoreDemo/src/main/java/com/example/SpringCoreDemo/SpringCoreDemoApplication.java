package com.example.SpringCoreDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.SpringCoreDemo2.CartService;

// Import the specific service from your second project package
// (If OrderService is also in that second project, import it too):
// import com.example1.SpringCoreDemo2.OrderService;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringCoreDemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

        // CartService cartService = new CartService();
        // cartService.addToCart();

        // User user = context.getBean(User.class);

        // System.out.println(user.getAge());

        // CartService cartService = context.getBean(CartService.class);
        // cartService.addToCart();



        ((AbstractApplicationContext) context).close();

    }
}