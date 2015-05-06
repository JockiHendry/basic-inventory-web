package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.JenisProduk;
import com.jocki.inventory.service.CrudService;

@Component
public class JenisProdukAction extends CrudAction<JenisProduk> {
	
	@Inject
	private CrudService<JenisProduk> jenisProdukService;
	
	@Override
	public CrudService<JenisProduk> getCrudService() {
		return jenisProdukService;
	}
	
}
