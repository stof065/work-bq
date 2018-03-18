package com.own.bq.util;

import java.util.function.Consumer;

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

	public static void executeActionifSpecificProfileActivated(String profile, Consumer<Void> consumer) {

		String activeProfile = environement.getProperty("spring.profiles.active");

		if (activeProfile != null && activeProfile.contains(profile)) {
			consumer.accept(null);

		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		environement = ctx.getEnvironment();
	}


}
