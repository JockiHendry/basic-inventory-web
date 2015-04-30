package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Cabang;
import com.jocki.inventory.service.CrudService;

@Component
public class CabangAction extends CrudAction<Cabang> {

	@Inject
	private CrudService<Cabang> cabangService;
	
	@Override
	public CrudService<Cabang> getCrudService() {
		return cabangService;
	}
	
}
