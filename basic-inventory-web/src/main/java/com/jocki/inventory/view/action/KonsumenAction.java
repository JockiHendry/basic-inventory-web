package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Konsumen;
import com.jocki.inventory.service.CrudService;

@Component
public class KonsumenAction extends CrudAction<Konsumen> {
	
	@Inject
	private CrudService<Konsumen> konsumenService;
	
	@Override
	public CrudService<Konsumen> getCrudService() {
		return konsumenService;
	}
	
}
