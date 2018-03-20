package com.own.bq.config.persistence;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {
	
	private static final Logger LOG = LoggerFactory.getLogger(LiquibaseConfiguration.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	GenericApplicationContext ctx;

	// implement a sort of condition on missionbean
	@PostConstruct
	public void liquibase() {
		
		LOG.info("-------------- check implementaion of liquibase to use ----------------------- ");
		if (!ctx.containsBean("liquibase")) {
			
			LOG.info("-------------- check implementaion of liquibase to use ----------------------- ")
			SpringLiquibase liquibase = new SpringLiquibase();
			liquibase.setChangeLog("classpath:db/liquibase-changeLog.xml");
			liquibase.setDataSource(dataSource);
			ctx.registerBean("liquibase", SpringLiquibase.class, 
					  () -> liquibase, bd -> bd.setAutowireCandidate(true));
			
		}else {
			
		}
	}
}
