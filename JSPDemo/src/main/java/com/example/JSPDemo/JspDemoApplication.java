package com.example.JSPDemo;

import java.io.File;
import java.util.Set;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JasperInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.JSPDemo.config.WebConfig;

public class JspDemoApplication {

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            tomcat.getConnector();

            String contextPath = "";
            String baseDoc = new File("src/main/webapp").getAbsolutePath();
            Context context = tomcat.addWebapp(contextPath, baseDoc);

            // Enable Jasper to process JSPs
            context.addServletContainerInitializer(new JasperInitializer(), Set.of());

            // Create the DispatcherServlet using AnnotationConfigWebApplicationContext directly
            AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
            springContext.register(WebConfig.class);

            DispatcherServlet dispatcherServlet = new DispatcherServlet();
            dispatcherServlet.setApplicationContext(springContext);

            // Register and map the dispatcher servlet
            org.apache.catalina.Wrapper servletWrapper = Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
            servletWrapper.setLoadOnStartup(1);
            context.addServletMappingDecoded("/", "dispatcherServlet");

            tomcat.start();
            System.out.println("Embedded Tomcat server started successfully on http://localhost:8080");

            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}