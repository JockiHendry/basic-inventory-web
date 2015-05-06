package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Konsumen;
import com.jocki.inventory.repository.FilterSpecification;
import com.jocki.inventory.repository.FilterSpecification.Operation;
import com.jocki.inventory.repository.KonsumenRepository;

public class KonsumenLazyDataModel extends PageableLazyDataModel<Konsumen> {
	
	private static final long serialVersionUID = -4881303476196069154L;
	
	@Inject
	private transient KonsumenRepository konsumenRepository;
	
	@Override
	public Page<Konsumen> load(Pageable pageable) {		
	    FilterSpecification<Konsumen> filterSpecification = new FilterSpecification<>();
		if (getFilter("nama") != null) {
		    filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		}
		if (getFilter("alamat") != null) {
		    filterSpecification.and("alamat", Operation.LIKE, getFilterAsSearchExpr("alamat"));
		}
		if (getFilter("kota") != null) {
		    filterSpecification.and("kota_nama", Operation.LIKE, getFilterAsSearchExpr("kota"));
		}
		return konsumenRepository.findAll(filterSpecification, pageable);
	}
}
