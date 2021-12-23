package com.epam.shop.dto;

public class QuantifiedProduct extends ProductWithImages {
	private Long quantity;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
