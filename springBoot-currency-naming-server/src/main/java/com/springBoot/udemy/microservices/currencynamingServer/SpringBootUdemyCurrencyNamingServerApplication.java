package com.springBoot.udemy.microservices.currencynamingServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootUdemyCurrencyNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyCurrencyNamingServerApplication.class, args);
	}

}
