package com.jocki.inventory.view.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.JenisProduk;
import com.jocki.inventory.repository.JenisProdukRepository;

public class JenisProdukLazyDataModel extends PageableLazyDataModel<JenisProduk> {
	
	private static final long serialVersionUID = -2614589025648419350L;
	
	@Inject
	private transient JenisProdukRepository jenisProdukRepository;

	@Override
	public Page<JenisProduk> load(Pageable pageable) {
		if (getFilter("kode") != null) {
			return jenisProdukRepository.findByKodeLike(getFilterAsSearchExpr("kode"), pageable);
		}
		if (getFilter("nama") != null) {
			return jenisProdukRepository.findByNamaLike(getFilterAsSearchExpr("nama"), pageable);
		}
		return jenisProdukRepository.findAll(pageable);
	}
			
}
