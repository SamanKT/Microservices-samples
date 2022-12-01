package com.springBoot.udemy.microservices.currencyapiGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilterForMe implements GlobalFilter{   // we can define global filters via gateway. Also authentications can be implemented here
														// the authentications are based on the webFlux and reactive projects
	private Logger myLogger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		myLogger.info(String.format("the request path is -> %s", exchange.getRequest().getPath()));
	//	myLogger.info("the request path is -> {}", exchange.getRequest().getPath());  // the second approach

		
		return chain.filter(exchange);
	}

}
