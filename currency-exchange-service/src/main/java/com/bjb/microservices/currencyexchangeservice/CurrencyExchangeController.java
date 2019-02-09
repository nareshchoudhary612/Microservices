package com.bjb.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment;
	
	@GetMapping("/currency-exchange/from/{c_from}/to/{c_to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String c_from, @PathVariable String c_to) {
		ExchangeValue ev =new ExchangeValue(10000L, c_from, c_to, BigDecimal.valueOf(65));
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return ev;
	}
}
