package com.bookstore.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class BookStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAppApplication.class, args);
	}

}
