package com.own.bq;

import org.bq.elastic.ElasticSearchMainConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.own.bq.config.persistence.JpaConfiguration;

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:application.properties" })
@EnableTransactionManagement
@EnableWebSecurity
@Import({ ElasticSearchMainConfiguration.class, JpaConfiguration.class })
public class ContextConfiguration {

	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
