package com.example.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FizzbuzzApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}

}
