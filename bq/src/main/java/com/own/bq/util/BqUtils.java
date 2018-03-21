package com.own.bq.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class BqUtils implements InitializingBean {

	
	static Environment environement;
	
	@Autowired
	ApplicationContext ctx ;

	public static void executeActionifSpecificProfileActivated(String profile, Runnable consumer) {

		String activeProfile = environement.getProperty("spring.profiles.active");

		if (activeProfile != null && activeProfile.contains(profile)) {
			consumer.run();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		environement = ctx.getEnvironment();
	}


}
