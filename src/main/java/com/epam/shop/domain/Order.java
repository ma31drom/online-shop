package com.epam.shop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

	private Long id;
	private LocalDateTime date;
	private BigDecimal totalAmount;
	private OrderStatus status;
	private Long deliveryAdress;
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

	public Long getDeliveryAdress() {
		return deliveryAdress;
	}

	public void setDeliveryAdress(Long deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
