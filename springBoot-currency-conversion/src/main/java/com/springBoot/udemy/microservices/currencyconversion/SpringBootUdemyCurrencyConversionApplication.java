package com.springBoot.udemy.microservices.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootUdemyCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyCurrencyConversionApplication.class, args);
	}

}
