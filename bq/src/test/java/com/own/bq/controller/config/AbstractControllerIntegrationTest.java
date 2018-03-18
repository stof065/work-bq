package com.own.bq.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;

@ContextConfiguration(classes = com.own.bq.ContextConfiguration.class)
@WebAppConfiguration( ) 
public abstract class AbstractControllerIntegrationTest extends AbstractTestNGSpringContextTests {

	protected RestTemplate restTemplate;



	@BeforeClass
	public void init() {
		restTemplate = new RestTemplate();
		authenticateRequest();
		 ;
		System.out.println(this);
	}

	private void authenticateRequest() {
		TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, null);
		authentication.setAuthenticated(true);
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

}
