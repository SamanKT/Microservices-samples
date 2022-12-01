package com.springBoot.udemy.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringBootUdemyConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUdemyConfigServerApplication.class, args);
	}

}
