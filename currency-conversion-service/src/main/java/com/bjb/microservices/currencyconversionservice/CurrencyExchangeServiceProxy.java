package com.bjb.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")  // name of the service we are going to call
//@FeignClient(name="currency-exchange-service") // after ribbon no need to hard code exchange service instance; still need to hard code it in application.property 
@FeignClient(name="netflix-zuul-api-gateway-server") // now we don't want currency conversion to directly call exchagne service, we want that to happen via zuul
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // now that we are calling service using zuul, url need to append service name
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
														@PathVariable("to") String to);
	
}


// Rationale behind making a proxy is that if there are 100 services to call then all of them can be configured here
// instead of writing everything on controller class