package com.szabo.landingpagebackend.interceptors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// import com.szabo.landingpagebackend.services.EmailService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JsonInterceptor implements HandlerInterceptor {

  // @Autowired
  // private EmailService emailService;

  @SuppressWarnings("null")
  @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // emailService.sendEmail("Novo JSON Recebido", json);

        return true;
    }
  
}
