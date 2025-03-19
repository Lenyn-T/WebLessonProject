package com.programming.web.fatec.api_fatec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI custonOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                .title("API for Web Lesson Project 1st semester of 2025")
                .version("0.1")
                .description("API documentation for Web Lesson project"));
    }
}
