package com.springBoot.udemy.microservices.currencyconversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBoot.udemy.microservices.currencyconversion.controller.model.CurrencyExchangeResponse;

@FeignClient(name="currency-exchange") // we dont provide uri so the feign will get the service details from Eureka naming service (discovery service)
public interface ConversionProxy {		// load balancing is also happening by feign based on the instances
										// in this case, the name MUST be the same as the name of the called service application name

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeResponse retrieveExchange(
			@PathVariable String from,
			@PathVariable String to);
}
