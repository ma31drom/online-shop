package com.epam.shop.repo;

import java.sql.Timestamp;
import java.util.Map;

import com.epam.shop.domain.Order;
import com.epam.shop.repo.mapping.OrderMapper;

public class OrderRepo extends AbstractCRUDRepository<Order> {

	private static OrderRepo instance;

	private OrderRepo() {
		super(new OrderMapper(), "shop_order");
		instance = this;
	}

	public static OrderRepo getInstance() {
		if (instance == null) {
			OrderRepo.instance = new OrderRepo();
		}
		return instance;
	}

	protected Map<String, String> updateValues(Order o) {
	
		return Map.of(
				"date", Timestamp.valueOf(o.getDate()).toString(), 
				"total_amount", o.getTotalAmount().toString(),
				"delivery_address_id", o.getDeliveryAdressId().toString(), 
				"status", String.valueOf(o.getStatus().ordinal()), 
				"person_id", o.getPersonId().toString()
				);
	}
}
