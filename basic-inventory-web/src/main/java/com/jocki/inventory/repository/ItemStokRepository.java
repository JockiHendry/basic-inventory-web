package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.ItemStok;

public interface ItemStokRepository extends JpaRepository<ItemStok, Long>, JpaSpecificationExecutor<ItemStok> {    
    
}
