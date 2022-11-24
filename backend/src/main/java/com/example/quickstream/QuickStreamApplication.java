package com.example.quickstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.company.project"})
public class QuickStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStreamApplication.class, args);
	}

}
