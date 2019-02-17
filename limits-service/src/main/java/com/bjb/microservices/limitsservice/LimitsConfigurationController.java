package com.bjb.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjb.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrivalLimitsFromConfigurations() {
		//return new LimitConfiguration(1000,1);
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}
