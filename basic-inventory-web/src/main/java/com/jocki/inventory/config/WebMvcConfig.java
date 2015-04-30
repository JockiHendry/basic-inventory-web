package com.jocki.inventory.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.mvc.JsfView;
import org.springframework.faces.webflow.JsfFlowHandlerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Inject
	private WebFlowConfig webFlowConfig;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/error").setViewName("error");
	}
	
    @Bean
    public UrlBasedViewResolver faceletsViewResolver() {
    	UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    	resolver.setViewClass(JsfView.class);
    	resolver.setPrefix("/WEB-INF/views/");
    	resolver.setSuffix(".xhtml");
    	return resolver;
    }
    
    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
    	FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
    	handlerMapping.setOrder(1);
    	handlerMapping.setFlowRegistry(webFlowConfig.flowRegistry());    	
    	return handlerMapping;
    }

    @Bean
    public JsfFlowHandlerAdapter flowHandlerAdapter() {
    	JsfFlowHandlerAdapter handlerAdapter = new JsfFlowHandlerAdapter();
    	handlerAdapter.setFlowExecutor(webFlowConfig.flowExecutor());    	
    	return handlerAdapter;
    }
    
    @Bean 
    public LoggingHandlerExceptionResolver exceptionResolver() {
    	return new LoggingHandlerExceptionResolver();
    }

}
