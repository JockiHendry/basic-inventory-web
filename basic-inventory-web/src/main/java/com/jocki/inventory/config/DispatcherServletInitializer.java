package com.jocki.inventory.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sun.faces.config.ConfigureListener;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { 
		return new Class[] { RootConfig.class, WebMvcConfig.class, WebFlowConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/app/*" };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");	
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		// Tambahkan konfigurasi development bila sedang tidak di-deploy di OpenShift
		if (System.getenv("OPENSHIFT_APP_NAME") == null) {
			servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
			servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");			
		} else {
			servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
		}			
		servletContext.addListener(ConfigureListener.class);
		super.onStartup(servletContext);
	}

}
