package com.jocki.inventory.view.action;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

public abstract class AbstractAction {
	
	public static final String FILTER_SEMUA = "(semua)";
	
	public void addInfoMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sukses", message);		
		FacesContext.getCurrentInstance().addMessage("pesanInformasi", facesMessage);
	}
	
	public void addErrorMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Terjadi kesalahan", message);		
		FacesContext.getCurrentInstance().addMessage("pesanInformasi", facesMessage);
	}	
	
	public void transition(String target) {
		RequestContext requestContext = RequestContextHolder.getRequestContext();
		RequestControlContext requestControl = (RequestControlContext) requestContext;
		requestControl.handleEvent(new Event(this, target));
	}
	
}
