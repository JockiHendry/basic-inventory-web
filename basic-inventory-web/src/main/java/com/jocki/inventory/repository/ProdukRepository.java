package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.Produk;

public interface ProdukRepository extends JpaRepository<Produk, Long>, JpaSpecificationExecutor<Produk> {

	
}
