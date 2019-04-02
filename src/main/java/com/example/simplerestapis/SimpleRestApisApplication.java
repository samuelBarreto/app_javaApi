package com.example.simplerestapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
public class SimpleRestApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApisApplication.class, args);
	}
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/value").allowedOrigins("http://app-javaapi.herokuapp.com");
	                registry.addMapping("/sample").allowedOrigins("http://app-javaapi.herokuapp.com");
	                registry.addMapping("/test").allowedOrigins("http://app-javaapi.herokuapp.com");
	            }
	        };
	    }
}
