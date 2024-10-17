package com.example.web_inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.web_inventory.repositories")
@EntityScan(basePackages = "com.example.web_inventory.entities")
public class WebInventoryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebInventoryApplication.class, args);
	}

}
