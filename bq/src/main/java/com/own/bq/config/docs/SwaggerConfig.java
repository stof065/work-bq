package com.own.bq.config.docs;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("pre-prod")
public class SwaggerConfig {
	@Bean
	public Docket api() {
		
		
		 AuthorizationScope[] authScopes = new AuthorizationScope[1];
		    authScopes[0] = new AuthorizationScopeBuilder()
		            .scope("read")
		            .description("read access")
		            .build();
		    SecurityReference securityReference = SecurityReference.builder()
		            .reference("abourouh")
		            .scopes(authScopes)
		            .build();
		    
		    List<SecurityContext> securityContexts = Collections.singletonList(
		            SecurityContext.builder()
		                    .securityReferences(Collections.singletonList(securityReference))
		                    .build());
		
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.securitySchemes(Collections.singletonList(new BasicAuth("abourouh")))
				.securityContexts(securityContexts);
	}

}