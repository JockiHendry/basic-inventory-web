package com.jocki.inventory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.ItemStok;
import com.jocki.inventory.domain.Produk;

public interface ItemStokRepository extends JpaRepository<ItemStok, Long>, JpaSpecificationExecutor<ItemStok> {

    public Page<ItemStok> findAllByProduk(Produk produk, Pageable pageable);
    
}
