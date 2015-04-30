package com.jocki.inventory.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class LoggingHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

	private static final Logger log = LoggerFactory.getLogger(LoggingHandlerExceptionResolver.class);
	
	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.error("Terjadi kesalahan di server: " + ex.getMessage(), ex);		
		return null;
	}

}
