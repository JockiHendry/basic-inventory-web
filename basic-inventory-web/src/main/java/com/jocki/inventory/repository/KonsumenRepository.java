package com.jocki.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.Konsumen;

public interface KonsumenRepository extends JpaRepository<Konsumen, Long> {

	Page<Konsumen> findByNamaLike(String nama, Pageable pageable);	
	
	Page<Konsumen> findByAlamatLike(String alamat, Pageable pageable);
			
	Page<Konsumen> findByKota_NamaLike(String namaKota, Pageable pageable);		
	
}
