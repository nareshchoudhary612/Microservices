package com.bjb.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		//this will give the current request that is being handled
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() { 
		// TODO Auto-generated method stub; should this filter be executed or not
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub ; this is used to set the priority between security filter, zuul loggin filter
		return 1;
	}

	@Override
	public String filterType() { // when to filter; like pre, post or during error
		// TODO Auto-generated method stub
		return "pre";
	}
	
}
