package com.jocki.inventory.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.config.FlowBuilderServicesBuilder;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;

@Configuration
public class WebFlowConfig extends AbstractFacesFlowConfiguration {
	
	@Inject
	Environment environment;
	
	@Bean
	public FlowExecutor flowExecutor() {
		return getFlowExecutorBuilder(flowRegistry())
			.addFlowExecutionListener(new FlowFacesContextLifecycleListener())
			.build();
	}
	
	@Bean
	public FlowDefinitionRegistry flowRegistry() {
		return getFlowDefinitionRegistryBuilder(flowBuilderServices())
			.setBasePath("/WEB-INF/flows")
			.addFlowLocationPattern("/**/*-flow.xml")			
			.build();
	}
	
	@Bean
	public FlowBuilderServices flowBuilderServices() {	
		FlowBuilderServicesBuilder builder = getFlowBuilderServicesBuilder();
		builder.setValidator(validator());
		if (environment.acceptsProfiles("dev")) {
			builder.setDevelopmentMode(true);
		}
		return builder.build();
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
}
