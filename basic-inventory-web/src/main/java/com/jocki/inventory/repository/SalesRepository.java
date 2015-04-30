package com.jocki.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	Page<Sales> findByNamaLike(String nama, Pageable pageable);
	
	Page<Sales> findByAlamatLike(String alamat, Pageable pageable);
	
	Page<Sales> findByNomorTeleponLike(String nomorTelepon, Pageable pageable);

}
