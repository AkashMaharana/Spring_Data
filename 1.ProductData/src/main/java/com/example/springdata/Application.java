package com.example.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @EnableJpaRepositories(basePackages = "com.example.repos")
 * 
 * @EntityScan(basePackages = "com.example.entities")
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
