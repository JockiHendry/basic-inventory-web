package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Supplier;
import com.jocki.inventory.repository.SupplierRepository;

@Service @Transactional
public class SupplierService implements CrudService<Supplier> {
	
	@Inject 
	private transient SupplierRepository supplierRepository;
	
	@Override
	public Supplier newInstance() {
		return new Supplier();
	}
	
	@Override
	public Supplier simpan(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	@Override
	public Supplier update(Supplier supplierBaru) {
		Supplier supplier = supplierRepository.findOne(supplierBaru.getId());
		supplier.setNama(supplierBaru.getNama());
		supplier.setAlamat(supplierBaru.getAlamat());
		supplier.setKota(supplierBaru.getKota());
		return supplier;
	}
	
	@Override
	public void hapus(Supplier supplier) {
		supplierRepository.delete(supplier.getId());
	}
	
}
