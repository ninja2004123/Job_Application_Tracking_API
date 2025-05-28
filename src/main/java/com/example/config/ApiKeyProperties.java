package com.example.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyProperties {
    private static final String API_KEY = "Happy Coding";

    public String getApiKey() {
        return API_KEY;
    }
}
