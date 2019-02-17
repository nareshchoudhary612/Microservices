package com.bjb.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	private String cfrom;
	private String cto;
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

	public ExchangeValue(Long id, String cfrom, String cto, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.cfrom = cfrom;
		this.cto = cto;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getcfrom() {
		return cfrom;
	}
	public void setcfrom(String cfrom) {
		this.cfrom = cfrom;
	}
	public String getcto() {
		return cto;
	}
	public void setcto(String cto) {
		this.cto = cto;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	} 
}
