package com.jocki.inventory.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Supplier;
import com.jocki.inventory.repository.SupplierRepository;

public class SupplierLazyDataModel extends PageableLazyDataModel<Supplier> {

	private static final long serialVersionUID = -2920326345903224281L;
	
	@Inject
	private transient SupplierRepository supplierRepository;
	
	@Override
	public Page<Supplier> load(Pageable pageable) {		
		if (getFilter("nama") != null) {
			return supplierRepository.findByNamaLike(getFilterAsSearchExpr("nama"), pageable);
		}
		if (getFilter("alamat") != null) {
			return supplierRepository.findByAlamatLike(getFilterAsSearchExpr("alamat"), pageable);
		}
		if (getFilter("kota") != null) {
			return supplierRepository.findByKota_NamaLike(getFilterAsSearchExpr("kota"), pageable);
		}
		return supplierRepository.findAll(pageable);
	}
	
}
