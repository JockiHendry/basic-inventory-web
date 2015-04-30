package com.jocki.inventory.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jocki.inventory.domain.Sales;
import com.jocki.inventory.repository.SalesRepository;

@Service @Transactional
public class SalesService implements CrudService<Sales> {
	
	@Inject 
	private transient SalesRepository salesRepository;
	
	@Override
	public Sales newInstance() {
		return new Sales();
	}
	
	@Override
	public Sales simpan(Sales sales) {
		return salesRepository.save(sales);
	}
	
	@Override
	public Sales update(Sales salesBaru) {
		Sales sales = salesRepository.findOne(salesBaru.getId());
		sales.setNama(salesBaru.getNama());
		sales.setAlamat(salesBaru.getAlamat());
		sales.setNomorTelepon(salesBaru.getNomorTelepon());
		return sales;
	}
	
	@Override
	public void hapus(Sales sales) {
		salesRepository.delete(sales.getId());
	}

}
