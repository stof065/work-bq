package com.own.bq.config.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.own.bq.util.BqUtils;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfiguration.class);


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		BqUtils.executeActionifSpecificProfileActivated("pre-prod", (Void x)->registerSwagger(registry));
		
		
	}

	private void registerSwagger(ResourceHandlerRegistry registry) {
		LOG.info("start registring swagger api docs");
		registry.addResourceHandler("**/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
