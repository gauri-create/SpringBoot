package com.example.SpringMVCDemo;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.SpringMVCDemo.config.WebConfig;

public class SpringMvcDemoApplication {

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            tomcat.getConnector();

            String contextPath = "";
            String baseDoc = new File("src/main/webapp").getAbsolutePath();
            Context context = tomcat.addContext(contextPath, baseDoc);

            AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
            springContext.register(WebConfig.class);
            
            DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

            org.apache.catalina.Wrapper servletWrapper = Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
            servletWrapper.setLoadOnStartup(1);

            context.addServletMappingDecoded("/", "dispatcher");

            tomcat.start();
            System.out.println("Spring MVC Tomcat server started successfully on http://localhost:8080");

            tomcat.getServer().await();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}