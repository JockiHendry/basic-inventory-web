package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.JenisProduk;
import com.jocki.inventory.repository.JenisProdukRepository;

@Service @Transactional
public class JenisProdukService implements CrudService<JenisProduk> {
	
	@Inject 
	private transient JenisProdukRepository jenisProdukRepository;
	
	@Override
	public JenisProduk newInstance() { 
		return new JenisProduk();
	}

	@Override
	public JenisProduk simpan(JenisProduk jenisProduk) {
		return jenisProdukRepository.save(jenisProduk);
	}

	@Override
	public JenisProduk update(JenisProduk jenisProdukBaru) {
		JenisProduk jenisProduk = jenisProdukRepository.findOne(jenisProdukBaru.getId());
		jenisProduk.setKode(jenisProdukBaru.getKode());
		jenisProduk.setNama(jenisProdukBaru.getNama());
		return jenisProduk;
	}

	@Override
	public void hapus(JenisProduk jenisProduk) {
		jenisProdukRepository.delete(jenisProduk.getId());
	}

}
