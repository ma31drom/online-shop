package com.epam.shop.repo;

import java.util.Map;

import com.epam.shop.domain.Payment;
import com.epam.shop.repo.mapping.PaymentMapper;

public class PaymentRepo extends AbstractCRUDRepository<Payment> {

	private static PaymentRepo instance;

	private PaymentRepo() {
		super(new PaymentMapper(), "payment");
		instance = this;
	}

	public static PaymentRepo getInstance() {
		if (instance == null) {
			PaymentRepo.instance = new PaymentRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Payment o) {
		return Map.of("status", String.valueOf(o.getStatus().ordinal()), "order_id", o.getOrderId().toString());
	}
}
