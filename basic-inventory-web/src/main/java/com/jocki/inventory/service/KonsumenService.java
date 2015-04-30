package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Konsumen;
import com.jocki.inventory.repository.KonsumenRepository;

@Service @Transactional
public class KonsumenService implements CrudService<Konsumen> {
	
	@Inject 
	private transient KonsumenRepository konsumenRepository;
	
	@Override
	public Konsumen newInstance() {
		return new Konsumen();
	}
	
	@Override
	public Konsumen simpan(Konsumen konsumen) {
		return konsumenRepository.save(konsumen);
	}
	
	@Override
	public Konsumen update(Konsumen konsumenBaru) {
		Konsumen konsumen = konsumenRepository.findOne(konsumenBaru.getId());
		konsumen.setNama(konsumenBaru.getNama());
		konsumen.setAlamat(konsumenBaru.getAlamat());
		konsumen.setKota(konsumenBaru.getKota());
		return konsumen;
	}
	
	@Override
	public void hapus(Konsumen konsumen) {
		konsumenRepository.delete(konsumen.getId());
	}
	
}
