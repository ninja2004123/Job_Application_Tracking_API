package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplicationTrackingAPI{
    public static void main(String[] args) {
        try {
            SpringApplication.run(JobApplicationTrackingAPI.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
