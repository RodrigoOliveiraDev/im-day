package com.rodrigo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class
ImDayApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImDayApplication.class, args);
	}
}
