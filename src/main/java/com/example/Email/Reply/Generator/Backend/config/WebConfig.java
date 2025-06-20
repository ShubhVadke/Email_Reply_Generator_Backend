package com.example.Email.Reply.Generator.Backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


//    @Value("${frontend.url}")
//    private String frontendUrl;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply CORS to all endpoints
                .allowedOrigins("https://ai-email-reply-generator-frontend-b5lz3j5yx.vercel.app/") // PROD: Replace with your frontend URL
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}