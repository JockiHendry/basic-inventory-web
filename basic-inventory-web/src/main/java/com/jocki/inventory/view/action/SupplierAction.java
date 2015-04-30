package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Supplier;
import com.jocki.inventory.service.CrudService;

@Component
public class SupplierAction extends CrudAction<Supplier> {

	@Inject
	private CrudService<Supplier> supplierService;
	
	@Override
	public CrudService<Supplier> getCrudService() {
		return supplierService;
	}	

}
