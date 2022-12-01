package com.springBoot.udemy.microservices.currencyexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.udemy.microservices.currencyexchange.bean.CurrencyExchangeModel;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeModel, Integer> {

	CurrencyExchangeModel findByFromAndTo(String from, String to);
}
