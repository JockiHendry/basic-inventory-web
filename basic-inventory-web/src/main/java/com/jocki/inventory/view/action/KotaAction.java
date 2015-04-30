package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Kota;
import com.jocki.inventory.service.CrudService;

@Component
public class KotaAction extends CrudAction<Kota> {

	@Inject
	private CrudService<Kota> kotaService;
	
	@Override
	public CrudService<Kota> getCrudService() {
		return kotaService;
	}

}
