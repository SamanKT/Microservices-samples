package com.springBoot.udemy.microservices.currencyexchange.contoller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.udemy.microservices.currencyexchange.bean.CurrencyExchangeModel;
import com.springBoot.udemy.microservices.currencyexchange.repository.CurrencyExchangeRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeModel retrieveExchange(
			@PathVariable String from,
			@PathVariable String to) {
		
		CurrencyExchangeModel exchangeModel = repository.findByFromAndTo(from, to);
		if (exchangeModel==null) throw new RuntimeException("not found bro!!");
		exchangeModel.setPortNumber(env.getProperty("local.server.port"));
		
		return exchangeModel;
	}
	
	
	@PostConstruct
	public void init() {
		repository.save(new CurrencyExchangeModel(1000L, "USD", "TR", BigDecimal.valueOf(45)));
		repository.save(new CurrencyExchangeModel(1001L, "EUR", "TR", BigDecimal.valueOf(55)));
		repository.save(new CurrencyExchangeModel(1002L, "GDB", "TR", BigDecimal.valueOf(80)));
		
	}
}
