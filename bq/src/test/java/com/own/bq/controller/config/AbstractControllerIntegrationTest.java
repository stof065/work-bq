package com.own.bq.controller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.own.bq.service.config.AbstractIntegrationTest;

@ContextConfiguration(classes = com.own.bq.ContextConfiguration.class)
@WebAppConfiguration
public abstract  class AbstractControllerIntegrationTest extends AbstractIntegrationTest {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractControllerIntegrationTest.class);

	protected RestTemplate restTemplate;

	protected MockMvc mockMvc;

	protected ObjectMapper mapper;

	@Autowired
	protected WebApplicationContext webApplicationContext;
	


	@BeforeClass
	public void initBeforeClass() {

		LOG.debug("start an abstract controller test");
		LOG.info("start an abstract controller test");

		mapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		authenticateRequest();

	}

	// methode to authenticate all request in a single class test
	//
	private void authenticateRequest() {
		TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, null);
		final SecurityContext securityContext = new SecurityContextImpl();
		securityContext.setAuthentication(authentication);
		SecurityContextHolder.setContext(securityContext);

	}

	@AfterClass
	public void clean() {

		LOG.debug("end an abstract controller test");
		LOG.info("end an abstract controller test");
	
	}
	

}
