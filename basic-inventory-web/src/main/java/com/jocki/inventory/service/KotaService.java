package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Kota;
import com.jocki.inventory.repository.KotaRepository;

@Service @Transactional
public class KotaService implements CrudService<Kota> {

	@Inject 
	private transient KotaRepository kotaRepository;
	
	@Override
	public Kota newInstance() {
		return new Kota();
	}
	
	@Override
	public Kota simpan(Kota kota) {
		return kotaRepository.save(kota);
	}
	
	@Override
	public Kota update(Kota kotaBaru) {
		Kota kota = kotaRepository.findOne(kotaBaru.getId());
		kota.setNama(kotaBaru.getNama());		
		return kota;
	}
	
	@Override
	public void hapus(Kota kota) {
		kotaRepository.delete(kota.getId());
	}
	
}
