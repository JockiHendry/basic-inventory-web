package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Cabang;
import com.jocki.inventory.repository.CabangRepository;
import com.jocki.inventory.repository.FilterSpecification;
import com.jocki.inventory.repository.FilterSpecification.Operation;

public class CabangLazyDataModel extends PageableLazyDataModel<Cabang> {

	private static final long serialVersionUID = 3916610621415723073L;
	
	@Inject
	private transient CabangRepository cabangRepository;	

	@Override
	public Page<Cabang> load(Pageable pageable) {	
	    FilterSpecification<Cabang> filterSpecification = new FilterSpecification<>();
		if (getFilter("nama") != null) {
		    filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		} 
		return cabangRepository.findAll(filterSpecification, pageable);
	}
	
}
