package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.JenisProduk;

public interface JenisProdukRepository extends JpaRepository<JenisProduk, Long>, JpaSpecificationExecutor<JenisProduk> {
	
}
