package com.jocki.inventory.view.action;

import javax.validation.constraints.NotNull;

import org.springframework.webflow.execution.RequestContext;

import com.jocki.inventory.service.CrudService;

public abstract class CrudAction<T> extends AbstractAction {
	
	public abstract CrudService<T> getCrudService();
	
	public String simpan(@NotNull T entity, RequestContext context) {
		try {
			getCrudService().simpan(entity);			
			context.getFlowScope().put("selectedEntity", getCrudService().newInstance());
			addInfoMessage("Data berhasil disimpan!");
			return "success";
		} catch (Exception ex) {
			addErrorMessage(ex.getMessage());
			return "error";
		}
	}
	
	public String update(@NotNull T entity, RequestContext context) {
		try {
			getCrudService().update(entity);						
			return "success";
		} catch (Exception ex) {
			addErrorMessage(ex.getMessage());
			return "error";
		}
	}
	
	public String hapus(@NotNull T entity, RequestContext context) {
		try {
			getCrudService().hapus(entity);
			return "success";
		} catch (Exception ex) {
			addErrorMessage(ex.getMessage());
			return "error";
		}
	}

}
