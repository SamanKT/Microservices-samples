package com.springBoot.udemy.microservices.currencyconversion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitController {

	private Logger myLogger = LoggerFactory.getLogger(this.getClass());
	private static int counter;
	
	@GetMapping("/test-resilience")
	//@Retry(name = "test-resilience" , fallbackMethod = "fallBackHandler")
	//@CircuitBreaker(name = "test-resilience" , fallbackMethod = "fallBackHandler") // to activate circuitBreaker over the responses
	@RateLimiter(name="test-resilience")
	@Bulkhead(name = "test-resilience")
	public String testingResilience() {
		myLogger.info("Trying to connect "+ counter++ );
		//RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/dummy-path", String.class); // a dummy path that cause fallback to test the resilience retry and fallback 
		return "the app is working";
	}
	
	
	public String fallBackHandler(Exception ex) {
		
		return "The service is down... please contact with the application developer";
	}
	
}
