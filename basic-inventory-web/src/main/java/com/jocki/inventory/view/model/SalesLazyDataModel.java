package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Sales;
import com.jocki.inventory.repository.SalesRepository;

public class SalesLazyDataModel extends PageableLazyDataModel<Sales>{

	private static final long serialVersionUID = 7007164117184212598L;
	
	@Inject
	private transient SalesRepository salesRepository;
	
	@Override
	public Page<Sales> load(Pageable pageable) {		
		if (getFilter("nama") != null) {
			return salesRepository.findByNamaLike(getFilterAsSearchExpr("nama"), pageable);
		}
		if (getFilter("alamat") != null) {
			return salesRepository.findByAlamatLike(getFilterAsSearchExpr("alamat"), pageable);
		}
		if (getFilter("nomorTelepon") != null) {
			return salesRepository.findByNomorTeleponLike(getFilterAsSearchExpr("nomorTelepon"), pageable);
		}
		return salesRepository.findAll(pageable);
	}

}
