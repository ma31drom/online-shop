package com.epam.shop.domain;

public class Payment {
	private Long id;
	private PaymentStatus status;
	private Long orederId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public Long getOrederId() {
		return orederId;
	}

	public void setOrederId(Long orederId) {
		this.orederId = orederId;
	}

}
