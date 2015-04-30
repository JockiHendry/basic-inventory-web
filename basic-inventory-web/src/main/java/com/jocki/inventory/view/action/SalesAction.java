package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Sales;
import com.jocki.inventory.service.CrudService;

@Component
public class SalesAction extends CrudAction<Sales> {
	
	@Inject
	private CrudService<Sales> salesService;
	
	@Override
	public CrudService<Sales> getCrudService() {
		return salesService;
	}	

}
