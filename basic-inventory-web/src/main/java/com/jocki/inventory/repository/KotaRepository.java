package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.Kota;

public interface KotaRepository extends JpaRepository<Kota, Long>, JpaSpecificationExecutor<Kota> {
	
}
