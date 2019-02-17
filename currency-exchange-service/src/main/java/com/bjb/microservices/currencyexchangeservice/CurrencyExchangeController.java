package com.bjb.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment environment;
	@Autowired
	ExchangeValuesRepository repository;
	
	@GetMapping("/currency-exchange/from/{cfrom}/to/{cto}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String cfrom, @PathVariable String cto) {
		/*ExchangeValue ev =new ExchangeValue(10000L, c_from, c_to, BigDecimal.valueOf(65));*/ //picking data from db
		
		ExchangeValue ev = repository.findByCfromAndCto(cfrom, cto);
			//	findByc_FromAndc_To(c_from, c_to);
		
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}", ev);
		return ev;
	}
}
