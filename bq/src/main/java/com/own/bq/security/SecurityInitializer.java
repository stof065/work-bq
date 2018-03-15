package com.own.bq.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}