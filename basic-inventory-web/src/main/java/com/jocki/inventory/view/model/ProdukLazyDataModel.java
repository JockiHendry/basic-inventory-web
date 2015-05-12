package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Produk;
import com.jocki.inventory.repository.specification.FilterSpecification;
import com.jocki.inventory.repository.specification.FilterSpecification.Operation;
import com.jocki.inventory.repository.ProdukRepository;

public class ProdukLazyDataModel extends PageableLazyDataModel<Produk> {
	
	private static final long serialVersionUID = 1061514813307378318L;
	
	@Inject
	private transient ProdukRepository produkRepository;	

	@Override
	public Page<Produk> load(Pageable pageable) {
		FilterSpecification<Produk> filterSpecification = new FilterSpecification<>();
		if (getFilter("kode") != null) {
			filterSpecification.and("kode", Operation.LIKE, getFilterAsSearchExpr("kode"));
		}
		if (getFilter("nama") != null) {
			filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		}
		if (getFilter("jenis") != null) {
			filterSpecification.and("jenis_id", Operation.EQ, getFilter("jenis"));
		}
		if (getFilter("harga") != null) {
			filterSpecification.and("harga", Operation.MIN, (String) getFilter("harga"));
		}
		if (getFilter("qty") != null) {
			filterSpecification.and("qty", Operation.MIN, (String) getFilter("qty"));
		}
		return produkRepository.findAll(filterSpecification, pageable);
	}
	
}
