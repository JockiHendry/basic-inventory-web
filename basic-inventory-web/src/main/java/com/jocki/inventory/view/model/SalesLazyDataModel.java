package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Sales;
import com.jocki.inventory.repository.FilterSpecification;
import com.jocki.inventory.repository.FilterSpecification.Operation;
import com.jocki.inventory.repository.SalesRepository;

public class SalesLazyDataModel extends PageableLazyDataModel<Sales>{

	private static final long serialVersionUID = 7007164117184212598L;
	
	@Inject
	private transient SalesRepository salesRepository;
	
	@Override
	public Page<Sales> load(Pageable pageable) {
	    FilterSpecification<Sales> filterSpecification = new FilterSpecification<>();
		if (getFilter("nama") != null) {
		    filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		}
		if (getFilter("alamat") != null) {
		    filterSpecification.and("alamat", Operation.LIKE, getFilterAsSearchExpr("alamat"));
		}
		if (getFilter("nomorTelepon") != null) {
		    filterSpecification.and("nomorTelepon", Operation.LIKE, getFilterAsSearchExpr("nomorTelepon"));
		}
		return salesRepository.findAll(filterSpecification, pageable);
	}

}
