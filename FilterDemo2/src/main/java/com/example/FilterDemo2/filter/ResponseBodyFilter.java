package com.example.FilterDemo2.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @Component
public class ResponseBodyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(httpServletResponse);

        filterChain.doFilter(servletRequest, wrappedResponse);

        byte[] originalBodyBytes = wrappedResponse.getContentAsByteArray();

        String originalBody = new String(originalBodyBytes);
        String modifiedBody = """
                {
                    "originalResponse":%s,
                    "appName":"Student Management System"
                }
                """.formatted(originalBody);

        wrappedResponse.resetBuffer();

        wrappedResponse.getWriter().write(modifiedBody);

        wrappedResponse.copyBodyToResponse();
    }

}
