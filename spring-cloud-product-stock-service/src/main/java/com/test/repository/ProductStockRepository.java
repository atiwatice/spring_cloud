package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.ProductStock;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
	ProductStock findByProductNameAndProductAvailability(String productName, String productAvailability);
}
