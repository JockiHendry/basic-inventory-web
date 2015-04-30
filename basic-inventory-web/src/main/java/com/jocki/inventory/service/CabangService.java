package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Cabang;
import com.jocki.inventory.repository.CabangRepository;

@Service @Transactional
public class CabangService implements CrudService<Cabang> {

	@Inject 
	private transient CabangRepository cabangRepository;
	
	@Override
	public Cabang newInstance() {
		return new Cabang();
	}
	
	@Override
	public Cabang simpan(Cabang cabang) {
		return cabangRepository.save(cabang);
	}
	
	@Override
	public Cabang update(Cabang cabangBaru) {
		Cabang cabang = cabangRepository.findOne(cabangBaru.getId());
		cabang.setNama(cabangBaru.getNama());		
		return cabang;
	}
	
	@Override
	public void hapus(Cabang cabang) {
		cabangRepository.delete(cabang.getId());
	}
	
}
