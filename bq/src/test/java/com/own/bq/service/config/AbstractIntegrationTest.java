package com.own.bq.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.own.bq.config.persistence.JpaConfiguration;

@ContextConfiguration(classes = { JpaConfiguration.class})
@TestPropertySource("classpath:application.properties")
public abstract class AbstractIntegrationTest extends AbstractTransactionalTestNGSpringContextTests  {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractIntegrationTest.class);


	@BeforeClass
	public void initilaizeFixture() {
		LOG.info("------------------------------ starting fixture---------------------------------");

	}

	@AfterClass
	public void clearFixtureData() {

		LOG.info("------------------------------ starting cleaning fixture data---------------------------------");

	}

}
