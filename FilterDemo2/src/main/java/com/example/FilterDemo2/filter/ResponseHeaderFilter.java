package com.example.FilterDemo2.filter;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

// @Component 
public class ResponseHeaderFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, 
        ServletResponse servletResponse, 
        FilterChain filterChain)
            throws IOException, ServletException {
        
                HttpServletResponse httpServletResponse = 
                            (HttpServletResponse) servletResponse;

                String  requestId = UUID.randomUUID().toString();
                httpServletResponse.setHeader("x-request-id", requestId);

                filterChain.doFilter(servletRequest, servletResponse);
    }

}
