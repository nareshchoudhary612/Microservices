package com.bjb.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	private String c_from;
	private String c_to;
	private BigDecimal conversionMultiple;
	private int port;
	
	public ExchangeValue() {
		
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ExchangeValue(Long id, String c_from, String c_to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.c_from = c_from;
		this.c_to = c_to;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getC_from() {
		return c_from;
	}
	public void setC_from(String c_from) {
		this.c_from = c_from;
	}
	public String getC_to() {
		return c_to;
	}
	public void setC_to(String c_to) {
		this.c_to = c_to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	} 
}
