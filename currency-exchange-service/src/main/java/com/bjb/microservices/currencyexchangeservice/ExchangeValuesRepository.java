package com.bjb.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValuesRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByCfromAndCto(String cfrom, String cto);
}
