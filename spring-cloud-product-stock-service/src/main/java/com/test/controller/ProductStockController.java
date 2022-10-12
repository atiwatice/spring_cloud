package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.ProductStockBean;
import com.test.entity.ProductStock;
import com.test.repository.ProductStockRepository;

@RestController
public class ProductStockController {

	@Autowired
	Environment environment;

	@Autowired
	ProductStockRepository productStockRepository;

	@GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public ProductStockBean checkProductStock(@PathVariable String productName,
			@PathVariable String productAvailability) {
		ProductStock productStock = productStockRepository.findByProductNameAndProductAvailability(productName,
				productAvailability);

		ProductStockBean productStockBean = ProductStockBean.builder()
												.id(productStock.getId())
												.productName(productStock.getProductName())
												.productPrice(productStock.getProductPrice())
												.productAvailability(productStock.getProductAvailability())
												.discountOffer(productStock.getDiscountOffer())
												.port(Integer.valueOf(environment.getProperty("local.server.port")))
												.build();
		return productStockBean;
	}
}
