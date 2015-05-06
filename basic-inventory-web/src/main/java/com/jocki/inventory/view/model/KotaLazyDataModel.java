package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Kota;
import com.jocki.inventory.repository.FilterSpecification;
import com.jocki.inventory.repository.FilterSpecification.Operation;
import com.jocki.inventory.repository.KotaRepository;

@Configurable
public class KotaLazyDataModel extends PageableLazyDataModel<Kota> {

	private static final long serialVersionUID = -5188457764185618290L;
		
	@Inject
	private transient KotaRepository kotaRepository;	

	@Override
	public Page<Kota> load(Pageable pageable) {	
	    FilterSpecification<Kota> filterSpecification = new FilterSpecification<>();
		if (getFilter("nama") != null) {		    
            filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));	        
		} 
		return kotaRepository.findAll(filterSpecification, pageable);
	}
	
}
