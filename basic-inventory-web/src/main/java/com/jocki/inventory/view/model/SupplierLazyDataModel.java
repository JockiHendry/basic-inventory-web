package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Supplier;
import com.jocki.inventory.repository.FilterSpecification;
import com.jocki.inventory.repository.FilterSpecification.Operation;
import com.jocki.inventory.repository.SupplierRepository;

public class SupplierLazyDataModel extends PageableLazyDataModel<Supplier> {

	private static final long serialVersionUID = -2920326345903224281L;
	
	@Inject
	private transient SupplierRepository supplierRepository;
	
	@Override
	public Page<Supplier> load(Pageable pageable) {
	    FilterSpecification<Supplier> filterSpecification = new FilterSpecification<>();
		if (getFilter("nama") != null) {
		    filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		}
		if (getFilter("alamat") != null) {
		    filterSpecification.and("alamat", Operation.LIKE, getFilterAsSearchExpr("alamat"));
		}
		if (getFilter("kota") != null) {
		    filterSpecification.and("kota_nama", Operation.LIKE, getFilterAsSearchExpr("kota"));
		}
		return supplierRepository.findAll(filterSpecification, pageable);
	}
	
}
