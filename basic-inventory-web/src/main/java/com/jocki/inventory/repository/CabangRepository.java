package com.jocki.inventory.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jocki.inventory.domain.Cabang;

public interface CabangRepository extends JpaRepository<Cabang, Long>, Serializable {

	Page<Cabang> findByNamaLike(String nama, Pageable pageable);
	
	Long countByNamaLike(String nama);
	
}
