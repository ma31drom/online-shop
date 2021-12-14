package com.epam.shop.domain;

import java.math.BigDecimal;

public class OrderProduct {

	private Long id;
	private Long quatity;
	private BigDecimal itemAmount;
	private Long orderId;
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuatity() {
		return quatity;
	}

	public void setQuatity(Long quatity) {
		this.quatity = quatity;
	}

	public BigDecimal getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
