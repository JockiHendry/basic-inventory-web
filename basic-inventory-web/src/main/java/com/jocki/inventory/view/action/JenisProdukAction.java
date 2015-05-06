package com.jocki.inventory.view.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.JenisProduk;
import com.jocki.inventory.repository.JenisProdukRepository;
import com.jocki.inventory.service.CrudService;

@Component
public class JenisProdukAction extends CrudAction<JenisProduk> {
	
	@Inject
	private CrudService<JenisProduk> jenisProdukService;
	
	@Inject
	private JenisProdukRepository jenisProdukRepository;
	
	public List<SelectItem> asFilter() {
		List<SelectItem> hasil = new ArrayList<>();
		hasil.add(new SelectItem(null, FILTER_SEMUA, "semua", false, false, true));
		for (JenisProduk jenisProduk: jenisProdukRepository.findAll()) {
			hasil.add(new SelectItem(jenisProduk.getId(), jenisProduk.getNama()));
		}
		return hasil;
	}
	
	@Override
	public CrudService<JenisProduk> getCrudService() {
		return jenisProdukService;
	}
	
}
