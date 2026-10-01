package com.example.InterceptorDemo.interceptor;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this);

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
				System.out.println("Incoming request ---------------");
				System.out.println("HTTP Method: "+ request.getMethod());
				System.out.println("Request parameters:"  + request.getQueryString());
				System.out.println("Client IP: "+request.getRemoteAddr());
				System.out.println("Token Header: " + request.getHeader("token"));
		
				if(handler instanceof HandlerMethod handlerMethod){
					System.out.println("Controller : "+ handlerMethod.getBeanType().getName());
					System.out.println("Controller Method: "+ handlerMethod.getMethod().getName());
				}
		        return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		System.out.println("Response Status: "+ response.getStatus());
	}

}
