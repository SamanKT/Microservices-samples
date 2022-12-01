package com.springBoot.udemy.microservices.currencyconversion.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.udemy.microservices.currencyconversion.controller.model.CurrencyConversion;
import com.springBoot.udemy.microservices.currencyconversion.controller.model.CurrencyExchangeResponse;
import com.springBoot.udemy.microservices.currencyconversion.proxy.ConversionProxy;

@RestController
public class ConversionController {
	
	@Autowired
	private ConversionProxy proxy;
	
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convert(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyExchangeResponse retrieveExchange = proxy.retrieveExchange(from, to);
		
		return new CurrencyConversion(retrieveExchange.getId(),quantity,retrieveExchange,quantity.multiply(retrieveExchange.getCurrencyRate()));
	}

}
