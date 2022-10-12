package com.test.beans;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@Builder
public class ProductStockBean {
	private Long id;
	private String productName;
	private BigDecimal productPrice;
	private String productAvailability;
	private double discountOffer;
	private int port;
	
	
}
