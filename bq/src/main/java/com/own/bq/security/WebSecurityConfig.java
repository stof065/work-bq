package com.own.bq.security;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.own.bq.security.filers.FilterCors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Bean
	Filter corsFilter() {
		return new FilterCors();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
		
		// skip swagger
		http.authorizeRequests().antMatchers("/rest/v2/api-docs", 
				"/configuration/ui", "/rest/swagger-resources/**",
				"/configuration/security", "/rest/swagger-ui.html**", "/rest/webjars/**").permitAll();
		
		
		
		http.csrf().disable().authorizeRequests().antMatchers("/**").hasRole("ADMIN").and().
		httpBasic().and().headers().frameOptions()
				.disable();
		
		http.addFilterBefore(corsFilter(), BasicAuthenticationFilter.class);


	}

	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("abourouh").password("abourouh").roles("ADMIN");
	}

}
