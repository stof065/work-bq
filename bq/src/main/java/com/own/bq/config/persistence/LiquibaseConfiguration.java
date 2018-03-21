package com.own.bq.config.persistence;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(LiquibaseConfiguration.class);

	
	@Value("${liquibase.changeLog.location}")
	String changeLogLocation;
	
	@Autowired
	DataSource dataSource;



	@Bean
	//@Conditional(IsPresentCondition.class)
	public SpringLiquibase liquibase() {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog(changeLogLocation);
		liquibase.setDataSource(dataSource);
		return liquibase;
	}

	// // implement a sort of condition on missionbean
	// @PostConstruct
	// public void liquibaseT() {
	//
	// GenericApplicationContext gctx = new GenericApplicationContext(ctx);
	//
	// LOG.info("-------------- check implementaion of liquibase to use
	// ----------------------- ");
	// if (!ctx.containsBean("liquibase")) {
	//
	// LOG.info("-------------- check implementaion of liquibase to use
	// ----------------------- ");
	// SpringLiquibase liquibase = new SpringLiquibase();
	// liquibase.setChangeLog("classpath:db/liquibase-changeLog.xml");
	// liquibase.setDataSource(dataSource);
	// gctx.registerBean("liquibase", SpringLiquibase.class,
	// () -> liquibase, bd -> bd.setAutowireCandidate(true));
	//
	// } else {
	//
	// }
	// }
}
