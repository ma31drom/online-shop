package com.epam.shop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.epam.shop.repo.WithId;

public class Order implements WithId {

	private Long id;
	private LocalDateTime date;
	private BigDecimal totalAmount;
	private OrderStatus status;
	private Long deliveryAdressId;
	private Long personId;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getDeliveryAdressId() {
		return deliveryAdressId;
	}

	public void setDeliveryAdressId(Long deliveryAdressId) {
		this.deliveryAdressId = deliveryAdressId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
