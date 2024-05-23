package com.example.lab6.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyController {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/myEntities/**")
                        .allowedOrigins("http://localhost:8080") // або інше джерело
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
