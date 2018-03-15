package com.own.bq.security.filers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterCors implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(FilterCors.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {
		LOG.info("------------------------pass Filter----------------------------");
		arg2.doFilter(arg0, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
