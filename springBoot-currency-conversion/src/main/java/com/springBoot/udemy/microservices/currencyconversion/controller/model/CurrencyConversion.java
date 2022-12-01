package com.springBoot.udemy.microservices.currencyconversion.controller.model;

import java.math.BigDecimal;

public class CurrencyConversion {

	private long id;

	private BigDecimal quantity;

	private CurrencyExchangeResponse response;

	private BigDecimal totalAmount;

	public CurrencyConversion() {
	}

	public CurrencyConversion(long id, BigDecimal quantity, CurrencyExchangeResponse response, BigDecimal totalAmount) {
		this.id = id;
		this.quantity = quantity;
		this.response = response;
		this.totalAmount = totalAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public CurrencyExchangeResponse getResponse() {
		return response;
	}

	public void setResponse(CurrencyExchangeResponse response) {
		this.response = response;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
