package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.JenisProduk;
import com.jocki.inventory.repository.specification.FilterSpecification;
import com.jocki.inventory.repository.specification.FilterSpecification.Operation;
import com.jocki.inventory.repository.JenisProdukRepository;

public class JenisProdukLazyDataModel extends PageableLazyDataModel<JenisProduk> {
	
	private static final long serialVersionUID = -2614589025648419350L;
	
	@Inject
	private transient JenisProdukRepository jenisProdukRepository;

	@Override
	public Page<JenisProduk> load(Pageable pageable) {
	    FilterSpecification<JenisProduk> filterSpecification = new FilterSpecification<>();
		if (getFilter("kode") != null) {
		    filterSpecification.and("kode", Operation.LIKE, getFilterAsSearchExpr("kode"));
		}
		if (getFilter("nama") != null) {
		    filterSpecification.and("nama", Operation.LIKE, getFilterAsSearchExpr("nama"));
		}
		return jenisProdukRepository.findAll(filterSpecification, pageable);
	}
			
}
