package com.jocki.inventory.config;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
	
	private static final Logger log = LoggerFactory.getLogger(WebFlowConfig.class);
	
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
	
	@Bean(name="flowBuilderServices") @Profile("!dev")
	public FlowBuilderServices flowBuilderServices() {
		log.info("Using production settings for FlowBuilderServices.");
		FlowBuilderServicesBuilder builder = getFlowBuilderServicesBuilder();
		builder.setValidator(validator());		
		return builder.build();
	}		
	
	@Bean(name="flowBuilderServices") @Profile("dev")
	public FlowBuilderServices flowBuilderServicesDev() {
		log.info("Using development settings for FlowBuilderServices.");
		FlowBuilderServicesBuilder builder = getFlowBuilderServicesBuilder();
		builder.setValidator(validator());		
		builder.setDevelopmentMode(true);		
		return builder.build();
	}
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
	
}
