package com.jocki.inventory.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.Kota;

public interface KotaRepository extends JpaRepository<Kota, Long>, Serializable {

	Page<Kota> findByNamaLike(String nama, Pageable pageable);
	
	Long countByNamaLike(String nama);
	
}
