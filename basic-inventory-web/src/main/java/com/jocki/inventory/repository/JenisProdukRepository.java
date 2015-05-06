package com.jocki.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.JenisProduk;

public interface JenisProdukRepository extends JpaRepository<JenisProduk, Long> {

	Page<JenisProduk> findByKodeLike(String kode, Pageable pageable);	
	
	Page<JenisProduk> findByNamaLike(String nama, Pageable pageable);					
	
}
