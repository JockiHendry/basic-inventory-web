package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.Cabang;

public interface CabangRepository extends JpaRepository<Cabang, Long>, JpaSpecificationExecutor<Cabang> {
	
}
