package com.bjb.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CurrencyExchangeServiceProxy cSEProxy;
	
	
	
/*************************************************************************************************************
 * Code to fetch data from another webservice currency exchange		
 ************************************************************************************************************/
	@GetMapping("/currency-converter/from/{cfrom}/to/{cto}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String cfrom,
												  @PathVariable String cto,
												  @PathVariable BigDecimal quantity
												  ) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("cfrom",cfrom);
		uriVariables.put("cto", cto);
		
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
										"http://localhost:8000/currency-exchange/from/{cfrom}/to/{cto}",
										CurrencyConversionBean.class,
										uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		return new CurrencyConversionBean(response.getId(),cfrom,cto,response.getConversionMultiple(),
											quantity,quantity.multiply(response.getConversionMultiple()),0);
	}
/*************************************************************************************************************/
	
	
	
// link to call from zuul http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10000	
/*************************************************************************************************************
* Code to fetch data from another webservice currency exchange using feign client	
************************************************************************************************************/
	@GetMapping("/currency-converter-feign/from/{cfrom}/to/{cto}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String cfrom,
												  @PathVariable String cto,
												  @PathVariable BigDecimal quantity
												  ) {		
				CurrencyConversionBean response = cSEProxy.retrieveExchangeValue(cfrom,cto);
				logger.info("{}", response);
				return new CurrencyConversionBean(response.getId(),cfrom,cto,response.getConversionMultiple(),
													quantity,quantity.multiply(response.getConversionMultiple()),0);
	}
/*************************************************************************************************************/
	
}
