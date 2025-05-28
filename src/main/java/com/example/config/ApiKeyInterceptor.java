package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor{
    public static final Logger logger = LoggerFactory.getLogger(ApiKeyInterceptor.class);
    public static final String API_KEY_HEADER = "X-API-KEY";
    
    private final ApiKeyProperties apiKeyProperties;

    public ApiKeyInterceptor(ApiKeyProperties apiKeyProperties) { this.apiKeyProperties = apiKeyProperties; }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handles) throws Exception {
        String method = request.getMethod();
        String path = request.getRequestURI();

        String apiKey = request.getHeader(API_KEY_HEADER);

        if (apiKey == null || !apiKey.equals(apiKeyProperties.getApiKey())) {
            logger.warn("Unauthorized access attempt: {} {} - Invalid or missing API key", method, path);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid or missing API key");
            return false;
        }

        logger.debug("API key authentication successful for: {} {}", method, path);
        return true;
    }
}
