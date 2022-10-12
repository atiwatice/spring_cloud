package com.test.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_stock")
public class ProductStock {
	@Id
	private Long id;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private BigDecimal productPrice;
	@Column(name = "product_availability")
	private String productAvailability;
	@Column(name = "discount_offer")
	private double discountOffer;

}
