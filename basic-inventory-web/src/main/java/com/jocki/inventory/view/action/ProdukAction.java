package com.jocki.inventory.view.action;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.Produk;
import com.jocki.inventory.service.CrudService;

@Component
public class ProdukAction extends CrudAction<Produk> {
	
	@Inject
	private CrudService<Produk> produkService;
	
	@Override
	public CrudService<Produk> getCrudService() {
		return produkService;
	}

}
