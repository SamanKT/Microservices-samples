package com.springBoot.udemy.microservices.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootUdemyCurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyCurrencyExchangeApplication.class, args);
	}

}
