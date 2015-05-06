package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Produk;
import com.jocki.inventory.repository.ProdukRepository;

@Service @Transactional
public class ProdukService implements CrudService<Produk> {
	
	@Inject
	ProdukRepository produkRepository;

	@Override
	public Produk newInstance() {
		return new Produk();
	}

	@Override
	public Produk simpan(Produk produk) {		
		return produkRepository.save(produk);
	}

	@Override
	public Produk update(Produk produkBaru) {
		Produk produk = produkRepository.findOne(produkBaru.getId());
		produk.setKode(produkBaru.getKode());
		produk.setNama(produkBaru.getNama());
		produk.setJenis(produkBaru.getJenis());
		produk.setHarga(produkBaru.getHarga());
		return produk;
		
	}

	@Override
	public void hapus(Produk produk) {
		produkRepository.delete(produk.getId());		
	}

}
