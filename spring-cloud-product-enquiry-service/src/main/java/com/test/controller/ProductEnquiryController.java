package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.ProductEnquiryBean;
import com.test.client.ProductStockClient;

@RestController
public class ProductEnquiryController {

	@Autowired
	ProductStockClient productStockClient;

	@GetMapping("/product-enquiry/name/{name}/availability/{availability}/unit/{unit}")
	public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name, @PathVariable String availability,
			@PathVariable Integer unit) {
		ProductEnquiryBean productEnquiryBean = productStockClient.checkProductStock(name, availability);

		Double totalPrice = productEnquiryBean.getProductPrice().doubleValue() * unit;
		Double discount = productEnquiryBean.getDiscountOffer();
		Double discountPrice = totalPrice - totalPrice * discount / 100;

		return ProductEnquiryBean.builder().id(productEnquiryBean.getId())
				.productName(productEnquiryBean.getProductName()).productPrice(productEnquiryBean.getProductPrice())
				.productAvailability(productEnquiryBean.getProductAvailability())
				.discountOffer(productEnquiryBean.getDiscountOffer()).unit(unit).totalPrice(discountPrice)
				.port(productEnquiryBean.getPort()).build();
	}
}
