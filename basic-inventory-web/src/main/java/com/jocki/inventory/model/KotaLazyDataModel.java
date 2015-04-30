package com.jocki.inventory.model;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jocki.inventory.domain.Kota;
import com.jocki.inventory.repository.KotaRepository;

@Configurable
public class KotaLazyDataModel extends PageableLazyDataModel<Kota> {

	private static final long serialVersionUID = -5188457764185618290L;
		
	@Inject
	private transient KotaRepository kotaRepository;	

	@Override
	public Page<Kota> load(Pageable pageable) {		
		if (getFilter("nama") != null) {
			return kotaRepository.findByNamaLike(getFilterAsSearchExpr("nama"), pageable);
		} 
		return kotaRepository.findAll(pageable);
	}
	
}
