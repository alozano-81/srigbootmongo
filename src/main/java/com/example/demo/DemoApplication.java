package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({ "com.example.demo.service" })
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = { "com.example.demo.repository" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")//
				.allowedOrigins("*")//
				.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")//
				.allowedHeaders("*");
			}
		};
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
