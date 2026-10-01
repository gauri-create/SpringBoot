package com.example.InterceptorDemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component 
public class AuthorizationInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, 
                            HttpServletResponse response, 
                            Object handler) throws Exception {
        String userRole = request.getHeader("x-user-role");

        if(userRole != null && !userRole.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\r\n" + //
                                "    \"message\":\"You are not Authorize to perform this action\"\r\n" + //
                                "}\r\n" + //
                                "");
            return false;
        }
        return true;
    }
}
