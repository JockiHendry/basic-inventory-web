package com.jocki.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jocki.inventory.domain.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>, JpaSpecificationExecutor<Sales> {		

}
