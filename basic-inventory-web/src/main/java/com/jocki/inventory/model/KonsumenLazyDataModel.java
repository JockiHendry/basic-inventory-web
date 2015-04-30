package com.jocki.inventory.model;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Konsumen;
import com.jocki.inventory.repository.KonsumenRepository;

public class KonsumenLazyDataModel extends PageableLazyDataModel<Konsumen> {
	
	private static final long serialVersionUID = -4881303476196069154L;
	
	@Inject
	private transient KonsumenRepository konsumenRepository;
	
	@Override
	public Page<Konsumen> load(Pageable pageable) {		
		if (getFilter("nama") != null) {
			return konsumenRepository.findByNamaLike(getFilterAsSearchExpr("nama"), pageable);
		}
		if (getFilter("alamat") != null) {
			return konsumenRepository.findByAlamatLike(getFilterAsSearchExpr("alamat"), pageable);
		}
		if (getFilter("kota") != null) {
			return konsumenRepository.findByKota_NamaLike(getFilterAsSearchExpr("kota"), pageable);
		}
		return konsumenRepository.findAll(pageable);
	}
}
