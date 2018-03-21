package com.own.bq.config.persistence;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import liquibase.integration.spring.SpringLiquibase;

public class IsPresentCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if(context.getBeanFactory().getBean(SpringLiquibase.class) != null) {
			return false;
		}
		return true;
	}

}
