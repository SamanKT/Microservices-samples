package com.springBoot.udemy.microservices.currencyexchange.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchangeModel {

	@Id
	private long id;
	
	@Column(name = "currency_from")
	private String from;
	
	@Column(name = "currency_to")
	private String to;
	
	private BigDecimal currencyRate;

	private String portNumber;
	
	public CurrencyExchangeModel(long id, String from, String to, BigDecimal currencyRate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.currencyRate = currencyRate;
	}
	
	public CurrencyExchangeModel() {
	
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
