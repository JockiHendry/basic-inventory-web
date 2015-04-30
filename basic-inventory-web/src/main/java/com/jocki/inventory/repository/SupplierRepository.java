package com.jocki.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.Kota;
import com.jocki.inventory.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	Page<Supplier> findByNamaLike(String nama, Pageable pageable);
	
	Long countByNamaLike(String nama);
	
	Page<Supplier> findByAlamatLike(String alamat, Pageable pageable);
	
	Long countByAlamatLike(String alamat);
	
	Page<Supplier> findByKota_NamaLike(String namaKota, Pageable pageable);
	
	Long countByKota(Kota kota);
	
}
