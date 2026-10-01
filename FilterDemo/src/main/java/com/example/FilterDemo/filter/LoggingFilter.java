package com.example.FilterDemo.filter;

import java.io.IOException;
import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order (2)
public class LoggingFilter implements Filter {

    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String requestId = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID", requestId);
        // Request log
        System.out.println("Incoming Request : "
                + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            long duration = System.currentTimeMillis() - startTime;

            // Response status log
            System.out.println("Response status: "
                    + httpResponse.getStatus());

            System.out.println("API response time : " + duration);
        }
    }

}
