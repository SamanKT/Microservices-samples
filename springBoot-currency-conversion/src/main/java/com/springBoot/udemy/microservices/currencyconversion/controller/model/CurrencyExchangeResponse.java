package com.springBoot.udemy.microservices.currencyconversion.controller.model;

import java.math.BigDecimal;



public class CurrencyExchangeResponse {

	
	private long id;
	
	
	private String from;
	
	private String to;
	
	private BigDecimal currencyRate;

	private String portNumber;
	
	public CurrencyExchangeResponse(long id, String from, String to, BigDecimal currencyRate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyRate = currencyRate;
	}
	
	public CurrencyExchangeResponse() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(BigDecimal currencyRate) {
		this.currencyRate = currencyRate;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	
}
