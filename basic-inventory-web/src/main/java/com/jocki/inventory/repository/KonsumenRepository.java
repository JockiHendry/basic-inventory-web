package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.Konsumen;

public interface KonsumenRepository extends JpaRepository<Konsumen, Long>, JpaSpecificationExecutor<Konsumen> {		
	
}
